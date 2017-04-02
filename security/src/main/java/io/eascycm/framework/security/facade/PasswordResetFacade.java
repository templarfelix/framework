package io.eascycm.framework.security.facade;

import io.eascycm.framework.base.facade.CrudFacade;
import io.eascycm.framework.security.entity.PasswordReset;
import io.eascycm.framework.security.entity.QPasswordReset;
import java.util.List;

public interface PasswordResetFacade extends CrudFacade<String, PasswordReset, QPasswordReset> {

  // Custom Methods
  public List<PasswordReset> findAll();

}