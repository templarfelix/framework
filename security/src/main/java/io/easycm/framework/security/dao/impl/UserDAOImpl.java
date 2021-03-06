package io.easycm.framework.security.dao.impl;

import io.easycm.framework.base.dao.exception.DaoException;
import io.easycm.framework.base.dao.impl.CrudDAOImpl;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.dao.UserDAO;
import io.easycm.framework.security.entity.QUser;
import io.easycm.framework.security.entity.User;
import io.easycm.framework.security.filter.UserFilterData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.jboss.security.auth.spi.Util;

@Stateless
// SECURITY
// @SecurityDomain("SecurityRealm")
// @RolesAllowed({ "Enabled" })
// @PermitAll
public class UserDAOImpl extends CrudDAOImpl<UUID, User, QUser> implements UserDAO {

  private static final long serialVersionUID = 1L;

  QUser qUser = QUser.user;

  @Override
  public List<User> findAll() {
    return findNamed("USER.FIND_ALL");
  }

  @Override
  public User findById(Long id) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", id);

    return super.findNamed("USER.FIND_BY_ID", params);
  }

  @Override
  public User findByLogin(String login) {
    UserFilterData filter = new UserFilterData();
    filter.setEmail(login);

    return super.findSingleQ(qUser, filter);
  }

  @Override
  public DataPage<User> findByFilter(UserFilterData filter, Page page) {

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("name", "%" + filter.getName() + "%");
    DataPage<User> dataPage = super.findListNamed("USER.LIKE_BY_NAME",
        "USER.COUNT_LIKE_BY_NAME", page, params);

    return dataPage;
  }

  @Override
  public User persist(User user) throws ValidationException,
      ConstraintViolationException, DaoException {
    makePassword(user);
    return super.persist(user);
  }

  @Override
  public User merge(User user) throws ValidationException,
      ConstraintViolationException, DaoException {

    checkPassword(user);
    return super.merge(user);
  }

  private void makePassword(User user) {
    user.setPassword(Util.createPasswordHash("SHA-256", "BASE64", null,
        null, user.getPassword()));
  }

  private void checkPassword(User user) {
    User userAntigo = findById(user.getId());
    if (!userAntigo.getPassword().equals(user.getPassword())) {
      user.setPassword(Util.createPasswordHash("SHA-256", "BASE64", null,
          null, user.getPassword()));
    }
  }
}