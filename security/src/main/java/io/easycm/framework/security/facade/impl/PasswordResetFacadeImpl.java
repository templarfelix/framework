package io.easycm.framework.security.facade.impl;

import io.easycm.framework.base.facade.impl.CrudFacadeImpl;
import io.easycm.framework.security.dao.PasswordResetDAO;
import io.easycm.framework.security.entity.PasswordReset;
import io.easycm.framework.security.entity.QPasswordReset;
import io.easycm.framework.security.facade.PasswordResetFacade;

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