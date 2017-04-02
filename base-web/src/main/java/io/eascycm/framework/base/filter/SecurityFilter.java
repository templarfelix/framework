package io.eascycm.framework.base.filter;

import io.eascycm.framework.security.entity.LoggedUser;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityFilter extends Filter {

  /* ATRIBUTOS DE SEGURANÇA */
  static String LOGIN_ATTRIBUTE_NAME = "LOGIN";
  static String LOGGED_USER_ATTRIBUTE_NAME = "LOGGED_USER";

  /**
   * @return void
   */
  void setUserParamSecurityContext(HttpServletRequest request);

  /**
   * @return boolean
   */
  boolean verifySecurityContext(HttpServletRequest request,
      HttpServletResponse response) throws IOException;

  /**
   * @return LoggedUser
   */
  LoggedUser setLoggedUser(HttpServletRequest request,
      String checkLogin);

}