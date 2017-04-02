package io.eascycm.framework.security.facade.impl;

import io.eascycm.framework.base.facade.impl.CrudFacadeImpl;
import io.eascycm.framework.security.dao.UserConfirmDAO;
import io.eascycm.framework.security.entity.QUserConfirm;
import io.eascycm.framework.security.entity.UserConfirm;
import io.eascycm.framework.security.facade.UserConfirmFacade;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserConfirmFacadeImpl extends
    CrudFacadeImpl<String, UserConfirm, QUserConfirm> implements
    UserConfirmFacade {

  private static final long serialVersionUID = 1L;

  @Inject
  public UserConfirmFacadeImpl(UserConfirmDAO dao) {
    super(dao);
  }

  @Override
  public List<UserConfirm> findAll() {
    return ((UserConfirmDAO) super.getDAO()).findAll();
  }
}