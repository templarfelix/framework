package io.easycm.framework.security.facade;

import io.easycm.framework.security.entity.User;
import java.security.Principal;
import javax.ejb.SessionContext;

public interface SecurityContext {

  public Principal getPrincipal();

  public User getUser();

  public SessionContext getContext();

}
