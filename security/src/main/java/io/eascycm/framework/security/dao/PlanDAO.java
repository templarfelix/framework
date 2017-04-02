package io.eascycm.framework.security.dao;

import io.eascycm.framework.base.dao.CrudDAO;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import io.eascycm.framework.security.entity.Plan;
import io.eascycm.framework.security.entity.QPlan;
import io.eascycm.framework.security.filter.PlanFilterData;
import java.util.List;
import java.util.UUID;

public interface PlanDAO extends CrudDAO<UUID, Plan, QPlan> {

  // Custom Methods
  public List<Plan> findAll();

  public DataPage<Plan> findByFilter(PlanFilterData filter, Page page);

}