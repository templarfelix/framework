package io.easycm.framework.security.facade.impl;

import io.easycm.framework.base.facade.impl.CrudFacadeImpl;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.dao.TenantDAO;
import io.easycm.framework.security.entity.QTenant;
import io.easycm.framework.security.entity.Tenant;
import io.easycm.framework.security.facade.TenantFacade;
import io.easycm.framework.security.filter.TenantFilterData;

import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TenantFacadeImpl extends CrudFacadeImpl<UUID, Tenant, QTenant>
    implements TenantFacade {

  private static final long serialVersionUID = 1L;

  @Inject
  public TenantFacadeImpl(TenantDAO dao) {
    super(dao);
  }

  @Override
  public DataPage<Tenant> findByFilter(TenantFilterData filter, Page page) {
    return ((TenantDAO) super.getDAO()).findByFilterQ(filter, page);
  }

  public Tenant findByFilter(TenantFilterData filter) {
    return ((TenantDAO) super.getDAO()).findByFilterQ(filter);
  }

  @Override
  public Tenant findById(String name) {
    TenantFilterData filter = new TenantFilterData();
    filter.setName(name);

    return ((TenantDAO) super.getDAO()).findByFilterQ(filter);
  }

  public DataPage<Tenant> zoom(TenantFilterData filter, Page page) {
    return ((TenantDAO) super.getDAO()).zoomQ(filter, page);
  }

  @Override
  public List<Tenant> findAll() {
    return ((TenantDAO) super.getDAO()).findAll();
  }
}
