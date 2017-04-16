package io.easycm.framework.security.dao.impl;

import io.easycm.framework.base.dao.impl.CrudDAOImpl;
import io.easycm.framework.security.dao.PasswordResetDAO;
import io.easycm.framework.security.entity.PasswordReset;
import io.easycm.framework.security.entity.QPasswordReset;
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