package io.eascycm.framework.security.dao;

import io.eascycm.framework.base.dao.CrudDAO;
import io.eascycm.framework.security.entity.QUserConfirm;
import io.eascycm.framework.security.entity.UserConfirm;
import java.util.List;

public interface UserConfirmDAO extends CrudDAO<String, UserConfirm, QUserConfirm> {

  // Custom Methods
  public List<UserConfirm> findAll();
}
