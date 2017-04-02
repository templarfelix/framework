package io.eascycm.framework.security.dao;

import io.eascycm.framework.base.dao.CrudDAO;
import io.eascycm.framework.security.entity.PasswordReset;
import io.eascycm.framework.security.entity.QPasswordReset;
import java.util.List;

public interface PasswordResetDAO extends CrudDAO<String, PasswordReset, QPasswordReset> {

  // Custom Methods
  public List<PasswordReset> findAll();
}