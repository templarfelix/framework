package io.eascycm.framework.security.dao.impl;

import io.eascycm.framework.base.dao.impl.CrudDAOImpl;
import io.eascycm.framework.security.dao.PasswordResetDAO;
import io.eascycm.framework.security.entity.PasswordReset;
import io.eascycm.framework.security.entity.QPasswordReset;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PasswordResetDAOImpl extends CrudDAOImpl<String, PasswordReset, QPasswordReset>
    implements PasswordResetDAO {

  private static final long serialVersionUID = 1L;

  @Override
  public List<PasswordReset> findAll() {
    return findNamed("PASSWORDRESET.FIND_ALL");
  }

}