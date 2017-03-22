package br.com.streamsoft.framework.security.dao;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.security.entity.PasswordReset;
import br.com.streamsoft.framework.security.entity.QPasswordReset;
import java.util.List;

public interface PasswordResetDAO extends CrudDAO<String, PasswordReset, QPasswordReset> {

  // Custom Methods
  public List<PasswordReset> findAll();
}