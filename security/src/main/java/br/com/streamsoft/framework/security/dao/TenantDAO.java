package br.com.streamsoft.framework.security.dao;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.QTenant;
import br.com.streamsoft.framework.security.entity.Tenant;
import br.com.streamsoft.framework.security.filter.TenantFilterData;

import java.util.List;
import java.util.UUID;

public interface TenantDAO extends CrudDAO<UUID, Tenant, QTenant>
{

    public Tenant findByFilterQ(TenantFilterData filter);

    public DataPage<Tenant> findByFilterQ(TenantFilterData filter, Page page);

    public DataPage<Tenant> zoomQ(TenantFilterData filter, Page page);

    public List<Tenant> findAll();
}
