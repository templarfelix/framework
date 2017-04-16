package io.easycm.framework.security.facade.impl;

import io.easycm.framework.base.facade.impl.CrudFacadeImpl;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.dao.RoleDAO;
import io.easycm.framework.security.entity.QRole;
import io.easycm.framework.security.entity.Role;
import io.easycm.framework.security.facade.RoleFacade;
import io.easycm.framework.security.filter.RoleFilterData;
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