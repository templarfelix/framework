package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.QRole;
import br.com.streamsoft.framework.security.entity.Role;
import br.com.streamsoft.framework.security.filter.RoleFilterData;

import java.util.List;

public interface RoleFacade extends CrudFacade<String, Role, QRole>
{

	// Custom Methods
	public List<Role> findAll();

	public Role findByRole(String role);

	public DataPage<Role> findByFilter(RoleFilterData filter, Page page);

}