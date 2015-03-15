package br.com.streamsoft.framework.security.facade.impl;

import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
import br.com.streamsoft.framework.security.dao.PasswordResetDAO;
import br.com.streamsoft.framework.security.entity.PasswordReset;
import br.com.streamsoft.framework.security.entity.QPasswordReset;
import br.com.streamsoft.framework.security.facade.PasswordResetFacade;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PasswordResetFacadeImpl extends CrudFacadeImpl<String, PasswordReset, QPasswordReset>
		implements
		PasswordResetFacade
{

	private static final long serialVersionUID = 1L;

	@Inject
	public PasswordResetFacadeImpl(PasswordResetDAO dao)
	{
		super(dao);
	}

	@Override
	public List<PasswordReset> findAll()
	{
		return ((PasswordResetDAO) super.getDAO()).findAll();
	}
}