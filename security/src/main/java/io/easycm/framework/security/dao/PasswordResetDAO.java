package io.easycm.framework.security.dao;

import io.easycm.framework.base.dao.CrudDAO;
import io.easycm.framework.security.entity.PasswordReset;
import io.easycm.framework.security.entity.QPasswordReset;
import java.util.List;

public interface PasswordResetDAO extends CrudDAO<String, PasswordReset, QPasswordReset> {

  // Custom Methods
  public List<PasswordReset> findAll();
}