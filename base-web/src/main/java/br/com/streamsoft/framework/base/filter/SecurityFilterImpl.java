package br.com.streamsoft.framework.base.filter;

import br.com.streamsoft.framework.base.dao.exception.DaoException;
import br.com.streamsoft.framework.security.entity.LoggedUser;
import br.com.streamsoft.framework.security.entity.User;
import br.com.streamsoft.framework.security.facade.UserFacade;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * Classe responsável por fazer o filtro de segurança do sistema
 *
 * @author Fernando<fernando@mksdev.com>
 * @version 1.0.0-SNAPSHOT
 */
public class SecurityFilterImpl implements SecurityFilter {

  protected String userParameterName;
  protected String logParameterName;
  protected Boolean validateSecurity;


  @Inject
  private Logger log;
  @Inject
  private UserFacade usuarioFacade;

  /**
   * Init do Security seta os parametros na classe
   *
   * @return void
   */
  @Override
  public void init(FilterConfig config) throws ServletException {

    this.userParameterName = config.getInitParameter("userParameterName");

    log.info("SecurityFilterImpl.init().userParameterName="
        + userParameterName);

    this.logParameterName = config.getInitParameter("logParameterName");

    log.info("SecurityFilterImpl.init().logParameterName="
        + logParameterName);

    this.validateSecurity = Boolean.parseBoolean(config
        .getInitParameter("validateSecurity"));

    log.info("SecurityFilterImpl.init().validateSecurity="
        + validateSecurity);
  }

  /**
   * Metodo Padrao do Filter
   *
   * @return void
   * @throws IOException , ServletException
   */
  @Override
  public void doFilter(ServletRequest req, ServletResponse res,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    try {
      if (!verifySecurityContext(request, response)) {
        response.sendError(HttpServletResponse.SC_FORBIDDEN,
            "access denied");
        return;
      }
    } catch (EJBException e) {
      String msg;
      if (e.getCause() != null) {
        msg = ExceptionUtils.getStackTrace(ExceptionUtils.getRootCause(e));
      } else {
        msg = ExceptionUtils.getStackTrace(e);
      }

      response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
          msg);
      return;
    } catch (Exception e) {
      String msg;
      if (e.getCause() != null) {
        msg = ExceptionUtils.getStackTrace(ExceptionUtils.getRootCause(e));
      } else {
        msg = ExceptionUtils.getStackTrace(e);
      }

      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
          msg);
      return;
    }
    chain.doFilter(req, res);
  }

  @Override
  public void destroy() {
  }

  /**
   * Verifica Autorização do usuário
   *
   * @return boolean
   */
  @Override
  public boolean verifySecurityContext(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    // logged User
    LoggedUser currentUser = (LoggedUser) request.getSession()
        .getAttribute(SecurityFilter.LOGGED_USER_ATTRIBUTE_NAME);

    if (currentUser == null) {

      // login
      setUserParamSecurityContext(request);
      String checkLogin = (String) request.getSession().getAttribute(
          SecurityFilter.LOGIN_ATTRIBUTE_NAME);

      if (checkLogin == null || checkLogin.isEmpty()) {
        return false;
      } else {
        currentUser = setLoggedUser(request, checkLogin);
      }
    }

    // burla validação
    if (!validateSecurity) {
      return true;
    }

    return false;
  }

  /**
   * Seta atributo referenciado o usuario logado
   *
   * @return void
   */
  @Override
  public void setUserParamSecurityContext(HttpServletRequest request) {
    if (this.userParameterName != null) {
      String login = (String) request.getSession().getAttribute(
          SecurityFilter.LOGIN_ATTRIBUTE_NAME);

      // nada a fazer se o valor ja foi setado anteriormente
      // para esta session
      if (login == null || login.isEmpty()) {

        // Pega usuario do padrao getRemoteUser();
        login = (String) request.getRemoteUser();

        if (login == null || login.isEmpty()) {

          // Pega usuario do OpenSSO ou OpenAM
          login = request
              .getHeader(SecurityFilter.LOGIN_ATTRIBUTE_NAME);
          if (login == null || login.isEmpty()) {
            login = request.getParameter(this.userParameterName);
          }
        }
        if (login != null && !login.isEmpty()) {
          request.getSession().setAttribute(
              SecurityFilter.LOGIN_ATTRIBUTE_NAME, login);
        }
      }
    }
  }

  /**
   * Seta todos os dados do usuário logado no sistema
   */
  public LoggedUser setLoggedUser(HttpServletRequest request, String checkLogin) {

    // cria novo loggedUser
    LoggedUser newLoggedUser = new LoggedUser();

    User currentUser = usuarioFacade.findByLogin(checkLogin);
    newLoggedUser.setSessionID(request.getSession(false).getId());
    newLoggedUser.setLogin(currentUser.getEmail());
    newLoggedUser.setName(currentUser.getName());
    newLoggedUser.setId(currentUser.getId());

    // update last login
    newLoggedUser.setLastLogin(new Date());
    currentUser.setLastLogin(newLoggedUser.getLastLogin());
    try {
      usuarioFacade.merge(currentUser);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // seta a nova data de log

    log.info(" ** New User Login ** " + newLoggedUser.toString());

    request.getSession().setAttribute(
        SecurityFilter.LOGGED_USER_ATTRIBUTE_NAME, newLoggedUser);

    return newLoggedUser;

  }
}