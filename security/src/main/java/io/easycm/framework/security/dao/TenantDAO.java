package io.easycm.framework.security.dao;

import io.easycm.framework.base.dao.CrudDAO;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.entity.QTenant;
import io.easycm.framework.security.entity.Tenant;
import io.easycm.framework.security.filter.TenantFilterData;

import java.util.List;
import java.util.UUID;

public interface TenantDAO extends CrudDAO<UUID, Tenant, QTenant> {

  public Tenant findByFilterQ(TenantFilterData filter);

  public DataPage<Tenant> findByFilterQ(TenantFilterData filter, Page page);

  public DataPage<Tenant> zoomQ(TenantFilterData filter, Page page);

  public List<Tenant> findAll();
}
