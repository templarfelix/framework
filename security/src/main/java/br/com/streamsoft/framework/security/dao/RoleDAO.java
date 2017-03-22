package br.com.streamsoft.framework.security.dao;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.QRole;
import br.com.streamsoft.framework.security.entity.Role;
import br.com.streamsoft.framework.security.filter.RoleFilterData;
import java.util.List;

public interface RoleDAO extends CrudDAO<String, Role, QRole> {

  // Custom Methods
  public List<Role> findAll();

  public Role findByRole(String role);

  public DataPage<Role> findByFilter(RoleFilterData filter, Page page);

}