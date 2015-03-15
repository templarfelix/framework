package br.com.streamsoft.framework.security.facade.impl;

import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
import br.com.streamsoft.framework.security.dao.UserConfirmDAO;
import br.com.streamsoft.framework.security.entity.QUserConfirm;
import br.com.streamsoft.framework.security.entity.UserConfirm;
import br.com.streamsoft.framework.security.facade.UserConfirmFacade;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserConfirmFacadeImpl extends CrudFacadeImpl<String, UserConfirm, QUserConfirm> implements
		UserConfirmFacade
{

	private static final long serialVersionUID = 1L;

	@Inject
	public UserConfirmFacadeImpl(UserConfirmDAO dao)
	{
		super(dao);
	}

	@Override
	public List<UserConfirm> findAll()
	{
		return ((UserConfirmDAO) super.getDAO()).findAll();
	}
}