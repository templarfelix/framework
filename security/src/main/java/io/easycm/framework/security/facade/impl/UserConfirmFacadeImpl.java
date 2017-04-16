package io.easycm.framework.security.facade.impl;

import io.easycm.framework.base.facade.impl.CrudFacadeImpl;
import io.easycm.framework.security.dao.UserConfirmDAO;
import io.easycm.framework.security.entity.QUserConfirm;
import io.easycm.framework.security.entity.UserConfirm;
import io.easycm.framework.security.facade.UserConfirmFacade;

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