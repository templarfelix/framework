package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.QTenant;
import br.com.streamsoft.framework.security.entity.Tenant;
import br.com.streamsoft.framework.security.filter.TenantFilterData;

import java.util.List;

public interface TenantFacade extends CrudFacade<Long, Tenant, QTenant>
{

    public DataPage<Tenant> findByFilter(TenantFilterData filter, Page page);

    public Tenant findByFilter(TenantFilterData filter);

    public Tenant findById(String id);

    public DataPage<Tenant> zoom(TenantFilterData filter, Page page);

    public List<Tenant> findAll();

}
