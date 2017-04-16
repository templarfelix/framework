package io.easycm.framework.security.facade;

import io.easycm.framework.base.facade.CrudFacade;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import io.easycm.framework.security.entity.Plan;
import io.easycm.framework.security.entity.QPlan;
import io.easycm.framework.security.filter.PlanFilterData;
import java.util.List;
import java.util.UUID;

public interface PlanFacade extends CrudFacade<UUID, Plan, QPlan> {

  // Custom Methods
  public List<Plan> findAll();

  public DataPage<Plan> findByFilter(PlanFilterData filter, Page page);

}