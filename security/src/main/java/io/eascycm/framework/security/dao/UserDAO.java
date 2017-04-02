package io.eascycm.framework.security.dao;

import io.eascycm.framework.base.dao.CrudDAO;
import io.eascycm.framework.base.dao.exception.DaoException;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.entity.QUser;
import io.eascycm.framework.security.entity.User;
import io.eascycm.framework.security.filter.UserFilterData;
import java.util.List;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

public interface UserDAO extends CrudDAO<UUID, User, QUser> {

  // Custom Methods
  public List<User> findAll();

  public User findById(Long id);

  public User findByLogin(String login);

  public DataPage<User> findByFilter(UserFilterData filter, Page page);

  public User merge(User obj) throws ValidationException,
      ConstraintViolationException, DaoException;

}