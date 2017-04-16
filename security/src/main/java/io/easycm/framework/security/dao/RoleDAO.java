package io.easycm.framework.security.dao;

import io.easycm.framework.base.dao.CrudDAO;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.entity.QRole;
import io.easycm.framework.security.entity.Role;
import io.easycm.framework.security.filter.RoleFilterData;

import java.util.List;

public interface RoleDAO extends CrudDAO<String, Role, QRole> {

  // Custom Methods
  public List<Role> findAll();

  public Role findByRole(String role);

  public DataPage<Role> findByFilter(RoleFilterData filter, Page page);

}