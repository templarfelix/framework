package br.com.streamsoft.framework.security.facade;

import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import br.com.streamsoft.framework.security.entity.Plan;
import br.com.streamsoft.framework.security.entity.QPlan;
import br.com.streamsoft.framework.security.filter.PlanFilterData;

import java.util.List;

public interface PlanFacade extends CrudFacade<Long, Plan, QPlan>
{

	// Custom Methods
	public List<Plan> findAll();

	public DataPage<Plan> findByFilter(PlanFilterData filter, Page page);

}