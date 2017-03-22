package br.com.streamsoft.framework.security.dao;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.Plan;
import br.com.streamsoft.framework.security.entity.QPlan;
import br.com.streamsoft.framework.security.filter.PlanFilterData;
import java.util.List;
import java.util.UUID;

public interface PlanDAO extends CrudDAO<UUID, Plan, QPlan> {

  // Custom Methods
  public List<Plan> findAll();

  public DataPage<Plan> findByFilter(PlanFilterData filter, Page page);

}