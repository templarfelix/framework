package io.eascycm.framework.security.facade.impl;

import io.eascycm.framework.base.facade.impl.CrudFacadeImpl;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.dao.PlanDAO;
import io.eascycm.framework.security.entity.Plan;
import io.eascycm.framework.security.entity.QPlan;
import io.eascycm.framework.security.facade.PlanFacade;
import io.eascycm.framework.security.filter.PlanFilterData;
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