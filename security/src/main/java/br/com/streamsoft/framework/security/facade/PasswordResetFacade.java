package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.security.entity.PasswordReset;
import br.com.streamsoft.framework.security.entity.QPasswordReset;
import java.util.List;

public interface PasswordResetFacade extends CrudFacade<String, PasswordReset, QPasswordReset> {

  // Custom Methods
  public List<PasswordReset> findAll();

}