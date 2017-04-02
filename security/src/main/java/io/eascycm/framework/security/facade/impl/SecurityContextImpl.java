package io.eascycm.framework.security.facade.impl;

import io.eascycm.framework.security.entity.User;
import io.eascycm.framework.security.facade.SecurityContext;
import io.eascycm.framework.security.facade.UserFacade;
import java.security.Principal;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
/**
 *
 * Classe responsável por trazer o Principal do contexto de segurança
 * */
public class SecurityContextImpl implements SecurityContext {

  @Resource
  private SessionContext context;

  @Inject
  private UserFacade facade;

  @Override
  public Principal getPrincipal() {
    return context.getCallerPrincipal();
  }

  public User getUser() {
    return facade.findByLogin(context.getCallerPrincipal().getName());
  }

  public SessionContext getContext() {
    return context;
  }

}
