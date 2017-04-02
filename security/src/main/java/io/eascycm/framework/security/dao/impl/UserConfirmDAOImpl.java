package io.eascycm.framework.security.dao.impl;

import io.eascycm.framework.base.dao.impl.CrudDAOImpl;
import io.eascycm.framework.security.dao.UserConfirmDAO;
import io.eascycm.framework.security.entity.QUserConfirm;
import io.eascycm.framework.security.entity.UserConfirm;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UserConfirmDAOImpl extends CrudDAOImpl<String, UserConfirm, QUserConfirm>
    implements UserConfirmDAO {

  private static final long serialVersionUID = 1L;

  @Override
  public List<UserConfirm> findAll() {
    return findNamed("USERCONFIRM.FIND_ALL");
  }

}