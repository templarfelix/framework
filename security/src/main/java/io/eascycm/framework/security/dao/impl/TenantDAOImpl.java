package io.eascycm.framework.security.dao.impl;

import io.eascycm.framework.base.dao.impl.CrudDAOImpl;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.base.security.Log;
import io.eascycm.framework.security.dao.TenantDAO;
import io.eascycm.framework.security.entity.QTenant;
import io.eascycm.framework.security.entity.Tenant;
import io.eascycm.framework.security.filter.TenantFilterData;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;

@Stateless
@Log
public class TenantDAOImpl extends CrudDAOImpl<UUID, Tenant, QTenant> implements TenantDAO {

  private static final long serialVersionUID = 1L;

  QTenant qTenant = QTenant.tenant;

  @Override
  public DataPage<Tenant> findByFilterQ(TenantFilterData filter, Page page) {
    return super.findQ(qTenant, filter, page);
  }

  public Tenant findByFilterQ(TenantFilterData filter) {
    return super.findSingleQ(qTenant, filter);
  }

  public DataPage<Tenant> zoomQ(TenantFilterData filter, Page page) {
    return super.findQ(qTenant, filter, page);
  }

  public List<Tenant> findAll() {
    return this.findNamed("TENANT.FIND_ALL");
  }
}
