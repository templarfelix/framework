package io.easycm.framework.security.facade;

import io.easycm.framework.base.facade.CrudFacade;
import io.easycm.framework.security.entity.PasswordReset;
import io.easycm.framework.security.entity.QPasswordReset;
import java.util.List;

public interface PasswordResetFacade extends CrudFacade<String, PasswordReset, QPasswordReset> {

  // Custom Methods
  public List<PasswordReset> findAll();

}