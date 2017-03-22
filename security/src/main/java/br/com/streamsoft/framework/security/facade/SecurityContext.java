package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.security.entity.User;
import java.security.Principal;
import javax.ejb.SessionContext;

public interface SecurityContext {

  public Principal getPrincipal();

  public User getUser();

  public SessionContext getContext();

}
