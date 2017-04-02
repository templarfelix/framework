package io.eascycm.framework.security.dao;

import io.eascycm.framework.base.dao.CrudDAO;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.entity.QRole;
import io.eascycm.framework.security.entity.Role;
import io.eascycm.framework.security.filter.RoleFilterData;
import java.util.List;

public interface RoleDAO extends CrudDAO<String, Role, QRole> {

  // Custom Methods
  public List<Role> findAll();

  public Role findByRole(String role);

  public DataPage<Role> findByFilter(RoleFilterData filter, Page page);

}