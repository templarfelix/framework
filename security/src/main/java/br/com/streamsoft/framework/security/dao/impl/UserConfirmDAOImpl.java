package br.com.streamsoft.framework.security.dao.impl;

import br.com.streamsoft.framework.base.dao.impl.CrudDAOImpl;
import br.com.streamsoft.framework.security.dao.UserConfirmDAO;
import br.com.streamsoft.framework.security.entity.QUserConfirm;
import br.com.streamsoft.framework.security.entity.UserConfirm;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserConfirmDAOImpl extends CrudDAOImpl<String, UserConfirm, QUserConfirm>
		implements UserConfirmDAO
{

	private static final long serialVersionUID = 1L;

	@Override
	public List<UserConfirm> findAll()
	{
		return findNamed("USERCONFIRM.FIND_ALL");
	}

}