package io.eascycm.framework.security.facade;

import io.eascycm.framework.base.facade.CrudFacade;
import io.eascycm.framework.security.entity.QUserConfirm;
import io.eascycm.framework.security.entity.UserConfirm;
import java.util.List;

public interface UserConfirmFacade extends CrudFacade<String, UserConfirm, QUserConfirm> {

  // Custom Methods
  public List<UserConfirm> findAll();

}