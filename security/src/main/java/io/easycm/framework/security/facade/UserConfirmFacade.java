package io.easycm.framework.security.facade;

import io.easycm.framework.base.facade.CrudFacade;
import io.easycm.framework.security.entity.QUserConfirm;
import io.easycm.framework.security.entity.UserConfirm;
import java.util.List;

public interface UserConfirmFacade extends CrudFacade<String, UserConfirm, QUserConfirm> {

  // Custom Methods
  public List<UserConfirm> findAll();

}