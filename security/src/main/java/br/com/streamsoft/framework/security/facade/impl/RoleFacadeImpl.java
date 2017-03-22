package br.com.streamsoft.framework.security.facade.impl;

import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.dao.RoleDAO;
import br.com.streamsoft.framework.security.entity.QRole;
import br.com.streamsoft.framework.security.entity.Role;
import br.com.streamsoft.framework.security.facade.RoleFacade;
import br.com.streamsoft.framework.security.filter.RoleFilterData;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RoleFacadeImpl extends CrudFacadeImpl<String, Role, QRole> implements
    RoleFacade {

  private static final long serialVersionUID = 1L;

  @Inject
  public RoleFacadeImpl(RoleDAO dao) {
    super(dao);
  }

  @Override
  public List<Role> findAll() {
    return ((RoleDAO) super.getDAO()).findAll();
  }

  @Override
  public Role findByRole(String role) {
    return ((RoleDAO) super.getDAO()).findByRole(role);
  }

  @Override
  public DataPage<Role> findByFilter(RoleFilterData filter, Page page) {
    return ((RoleDAO) super.getDAO()).findByFilter(filter, page);
  }

}