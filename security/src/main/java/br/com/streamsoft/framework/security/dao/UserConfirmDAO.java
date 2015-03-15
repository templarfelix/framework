package br.com.streamsoft.framework.security.dao;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.security.entity.QUserConfirm;
import br.com.streamsoft.framework.security.entity.UserConfirm;

import java.util.List;

public interface UserConfirmDAO extends CrudDAO<String, UserConfirm, QUserConfirm>
{

	// Custom Methods
	public List<UserConfirm> findAll();
}
