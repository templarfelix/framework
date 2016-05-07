package br.com.streamsoft.framework.security.facade.impl;

import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.dao.TenantDAO;
import br.com.streamsoft.framework.security.entity.QTenant;
import br.com.streamsoft.framework.security.entity.Tenant;
import br.com.streamsoft.framework.security.facade.TenantFacade;
import br.com.streamsoft.framework.security.filter.TenantFilterData;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TenantFacadeImpl extends CrudFacadeImpl<Long, Tenant, QTenant>
        implements TenantFacade
{

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
