package io.eascycm.framework.security.dao.impl;

import io.eascycm.framework.base.dao.impl.CrudDAOImpl;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.dao.RoleDAO;
import io.eascycm.framework.security.entity.QRole;
import io.eascycm.framework.security.entity.Role;
import io.eascycm.framework.security.filter.RoleFilterData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless

//@SecurityDomain("SecurityRealm")
//@RolesAllowed({ "Enabled" })
//@PermitAll
public class RoleDAOImpl extends CrudDAOImpl<String, Role, QRole> implements RoleDAO {

  private static final long serialVersionUID = 1L;

  @Override
  public List<Role> findAll() {
    return findNamed("ROLE.FIND_ALL");
  }

  @Override
  public Role findByRole(String role) {

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("role", role);

    return super.findNamed("ROLE.FIND_BY_ROLE", params);
  }

  @Override
  public DataPage<Role> findByFilter(RoleFilterData filter, Page page) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("role", "%" + filter.getRole() + "%");

    return super.findListNamed("ROLE.LIKE_BY_ROLE", "ROLE.COUNT_LIKE_BY_ROLE", page, params);
  }

}