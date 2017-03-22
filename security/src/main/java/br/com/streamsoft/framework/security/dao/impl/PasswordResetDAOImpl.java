package br.com.streamsoft.framework.security.dao.impl;

import br.com.streamsoft.framework.base.dao.impl.CrudDAOImpl;
import br.com.streamsoft.framework.security.dao.PasswordResetDAO;
import br.com.streamsoft.framework.security.entity.PasswordReset;
import br.com.streamsoft.framework.security.entity.QPasswordReset;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PasswordResetDAOImpl extends CrudDAOImpl<String, PasswordReset, QPasswordReset>
    implements PasswordResetDAO {

  private static final long serialVersionUID = 1L;

  @Override
  public List<PasswordReset> findAll() {
    return findNamed("PASSWORDRESET.FIND_ALL");
  }

}