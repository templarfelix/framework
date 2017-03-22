package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.security.entity.QUserConfirm;
import br.com.streamsoft.framework.security.entity.UserConfirm;
import java.util.List;

public interface UserConfirmFacade extends CrudFacade<String, UserConfirm, QUserConfirm> {

  // Custom Methods
  public List<UserConfirm> findAll();

}