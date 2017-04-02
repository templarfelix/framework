package io.eascycm.framework.security.facade;

import io.eascycm.framework.base.facade.CrudFacade;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.entity.QTenant;
import io.eascycm.framework.security.entity.Tenant;
import io.eascycm.framework.security.filter.TenantFilterData;
import java.util.List;
import java.util.UUID;

public interface TenantFacade extends CrudFacade<UUID, Tenant, QTenant> {

  public DataPage<Tenant> findByFilter(TenantFilterData filter, Page page);

  public Tenant findByFilter(TenantFilterData filter);

  public Tenant findById(String id);

  public DataPage<Tenant> zoom(TenantFilterData filter, Page page);

  public List<Tenant> findAll();

}
