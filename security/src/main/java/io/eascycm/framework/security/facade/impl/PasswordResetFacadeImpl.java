package io.eascycm.framework.security.facade.impl;

import io.eascycm.framework.base.facade.impl.CrudFacadeImpl;
import io.eascycm.framework.security.dao.PasswordResetDAO;
import io.eascycm.framework.security.entity.PasswordReset;
import io.eascycm.framework.security.entity.QPasswordReset;
import io.eascycm.framework.security.facade.PasswordResetFacade;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PasswordResetFacadeImpl extends CrudFacadeImpl<String, PasswordReset, QPasswordReset>
    implements
    PasswordResetFacade {

  private static final long serialVersionUID = 1L;

  @Inject
  public PasswordResetFacadeImpl(PasswordResetDAO dao) {
    super(dao);
  }

  @Override
  public List<PasswordReset> findAll() {
    return ((PasswordResetDAO) super.getDAO()).findAll();
  }
}