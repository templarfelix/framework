package io.eascycm.framework.security.dao;

import io.eascycm.framework.base.dao.CrudDAO;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.entity.QTenant;
import io.eascycm.framework.security.entity.Tenant;
import io.eascycm.framework.security.filter.TenantFilterData;
import java.util.List;
import java.util.UUID;

public interface TenantDAO extends CrudDAO<UUID, Tenant, QTenant> {

  public Tenant findByFilterQ(TenantFilterData filter);

  public DataPage<Tenant> findByFilterQ(TenantFilterData filter, Page page);

  public DataPage<Tenant> zoomQ(TenantFilterData filter, Page page);

  public List<Tenant> findAll();
}
