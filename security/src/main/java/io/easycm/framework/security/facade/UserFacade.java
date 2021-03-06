package io.easycm.framework.security.facade;

import io.easycm.framework.base.facade.CrudFacade;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.entity.QUser;
import io.easycm.framework.security.entity.User;
import io.easycm.framework.security.filter.UserFilterData;

import java.util.List;
import java.util.UUID;

public interface UserFacade extends CrudFacade<UUID, User, QUser> {

  // Custom Methods
  public List<User> findAll();

  public User findByLogin(String login);

  public DataPage<User> findByFilter(UserFilterData filter, Page page);

  public User register(User user) throws Exception;

  public User confirmRegister(String uuid) throws Exception;

  public boolean lostPassword(String login) throws Exception;

  public boolean resetPassword(String uuid, String newPassword) throws Exception;

}