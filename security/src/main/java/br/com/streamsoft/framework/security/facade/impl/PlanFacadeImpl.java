package br.com.streamsoft.framework.security.facade.impl;

import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.dao.PlanDAO;
import br.com.streamsoft.framework.security.entity.Plan;
import br.com.streamsoft.framework.security.entity.QPlan;
import br.com.streamsoft.framework.security.facade.PlanFacade;
import br.com.streamsoft.framework.security.filter.PlanFilterData;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PlanFacadeImpl extends CrudFacadeImpl<UUID, Plan, QPlan> implements
    PlanFacade {

  private static final long serialVersionUID = 1L;

  @Inject
  public PlanFacadeImpl(PlanDAO dao) {
    super(dao);
  }

  @Override
  public List<Plan> findAll() {
    return ((PlanDAO) super.getDAO()).findAll();
  }

  @Override
  public DataPage<Plan> findByFilter(PlanFilterData filter, Page page) {
    return ((PlanDAO) super.getDAO()).findByFilter(filter, page);
  }

}