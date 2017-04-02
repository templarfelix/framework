package io.eascycm.framework.security.facade;

import io.eascycm.framework.security.entity.User;
import java.security.Principal;
import javax.ejb.SessionContext;

public interface SecurityContext {

  public Principal getPrincipal();

  public User getUser();

  public SessionContext getContext();

}
