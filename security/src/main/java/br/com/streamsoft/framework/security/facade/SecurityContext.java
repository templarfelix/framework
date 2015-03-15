package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.security.entity.User;

import javax.ejb.SessionContext;
import java.security.Principal;

public interface SecurityContext
{

	public Principal getPrincipal();

	public User getUser();

	public SessionContext getContext();

}
