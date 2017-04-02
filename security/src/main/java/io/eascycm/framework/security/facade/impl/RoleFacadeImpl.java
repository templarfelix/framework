package io.eascycm.framework.security.facade.impl;

import io.eascycm.framework.base.facade.impl.CrudFacadeImpl;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.dao.RoleDAO;
import io.eascycm.framework.security.entity.QRole;
import io.eascycm.framework.security.entity.Role;
import io.eascycm.framework.security.facade.RoleFacade;
import io.eascycm.framework.security.filter.RoleFilterData;
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