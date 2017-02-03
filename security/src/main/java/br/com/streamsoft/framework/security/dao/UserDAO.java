package br.com.streamsoft.framework.security.dao;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.base.dao.exception.DaoException;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.QUser;
import br.com.streamsoft.framework.security.entity.User;
import br.com.streamsoft.framework.security.filter.UserFilterData;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

public interface UserDAO extends CrudDAO<UUID, User, QUser>
{

	// Custom Methods
	public List<User> findAll();

	public User findById(Long id);

	public User findByLogin(String login);

	public DataPage<User> findByFilter(UserFilterData filter, Page page);

	public User merge(User obj) throws ValidationException,
			ConstraintViolationException, DaoException;

}