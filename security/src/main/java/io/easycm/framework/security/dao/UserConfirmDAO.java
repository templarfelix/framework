package io.easycm.framework.security.dao;

import io.easycm.framework.base.dao.CrudDAO;
import io.easycm.framework.security.entity.QUserConfirm;
import io.easycm.framework.security.entity.UserConfirm;
import java.util.List;

public interface UserConfirmDAO extends CrudDAO<String, UserConfirm, QUserConfirm> {

  // Custom Methods
  public List<UserConfirm> findAll();
}
