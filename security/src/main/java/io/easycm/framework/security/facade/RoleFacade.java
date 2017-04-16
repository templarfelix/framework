package io.easycm.framework.security.facade;

import io.easycm.framework.base.facade.CrudFacade;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.entity.QRole;
import io.easycm.framework.security.entity.Role;
import io.easycm.framework.security.filter.RoleFilterData;

import java.util.List;

public interface RoleFacade extends CrudFacade<String, Role, QRole> {

  // Custom Methods
  public List<Role> findAll();

  public Role findByRole(String role);

  public DataPage<Role> findByFilter(RoleFilterData filter, Page page);

}