package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.QUser;
import br.com.streamsoft.framework.security.entity.User;
import br.com.streamsoft.framework.security.filter.UserFilterData;

import java.util.List;

public interface UserFacade extends CrudFacade<Long, User, QUser>
{

	// Custom Methods
	public List<User> findAll();

	public User findByLogin(String login);

	public DataPage<User> findByFilter(UserFilterData filter, Page page);

	public User register(User user) throws Exception;

	public User confirmRegister(String uuid) throws Exception;

	public boolean lostPassword(String login) throws Exception;

	public boolean resetPassword(String uuid, String newPassword) throws Exception;

}