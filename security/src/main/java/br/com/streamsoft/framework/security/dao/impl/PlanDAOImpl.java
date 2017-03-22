package br.com.streamsoft.framework.security.dao.impl;

import br.com.streamsoft.framework.base.dao.impl.CrudDAOImpl;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.dao.PlanDAO;
import br.com.streamsoft.framework.security.entity.Plan;
import br.com.streamsoft.framework.security.entity.QPlan;
import br.com.streamsoft.framework.security.filter.PlanFilterData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Stateless;

@Stateless
public class PlanDAOImpl extends CrudDAOImpl<UUID, Plan, QPlan> implements PlanDAO {

  private static final long serialVersionUID = 1L;

  @Override
  public List<Plan> findAll() {
    return findNamed("PLAN.FIND_ALL");
  }

  @Override
  public DataPage<Plan> findByFilter(PlanFilterData filter, Page page) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("name", "%" + filter.getName() + "%");

    return super.findListNamed("PLAN.LIKE_BY_NAME", "PLAN.COUNT_LIKE_BY_NAME", page, params);
  }

}