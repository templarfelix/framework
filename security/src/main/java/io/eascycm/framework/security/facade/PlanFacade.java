package io.eascycm.framework.security.facade;

import io.eascycm.framework.base.facade.CrudFacade;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.entity.Plan;
import io.eascycm.framework.security.entity.QPlan;
import io.eascycm.framework.security.filter.PlanFilterData;
import java.util.List;
import java.util.UUID;

public interface PlanFacade extends CrudFacade<UUID, Plan, QPlan> {

  // Custom Methods
  public List<Plan> findAll();

  public DataPage<Plan> findByFilter(PlanFilterData filter, Page page);

}