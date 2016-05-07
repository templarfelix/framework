package br.com.streamsoft.framework.security.dao.impl;

import br.com.streamsoft.framework.base.dao.impl.CrudDAOImpl;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.base.security.Log;
import br.com.streamsoft.framework.security.dao.TenantDAO;
import br.com.streamsoft.framework.security.entity.QTenant;
import br.com.streamsoft.framework.security.entity.Tenant;
import br.com.streamsoft.framework.security.filter.TenantFilterData;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Log
public class TenantDAOImpl extends CrudDAOImpl<Long, Tenant, QTenant> implements TenantDAO
{

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
