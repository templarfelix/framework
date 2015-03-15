package br.com.streamsoft.framework.security.facade.impl;

import br.com.streamsoft.framework.security.entity.User;
import br.com.streamsoft.framework.security.facade.SecurityContext;
import br.com.streamsoft.framework.security.facade.UserFacade;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.Principal;

@Stateless
/**
 *
 * Classe responsável por trazer o Principal do contexto de segurança
 * */
public class SecurityContextImpl implements SecurityContext
{

	@Resource
	private SessionContext context;

	@Inject
	private UserFacade facade;

	@Override
	public Principal getPrincipal()
	{
		return context.getCallerPrincipal();
	}

	public User getUser()
	{
		return facade.findByLogin(context.getCallerPrincipal().getName());
	}

	public SessionContext getContext()
	{
		return context;
	}

}
