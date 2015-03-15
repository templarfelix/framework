package br.com.streamsoft.framework.base.facade.impl;

import br.com.streamsoft.framework.base.dao.ReportDAO;
import br.com.streamsoft.framework.base.facade.ReportFacade;
import br.com.streamsoft.framework.base.filter.FilterData;

import java.util.List;

public class ReportFacadeImpl<V, K extends FilterData> implements
		ReportFacade<V, K>
{
	private static final long serialVersionUID = 1L;

	private ReportDAO<V, K> dao;

	public ReportFacadeImpl(ReportDAO<V, K> dao)
	{
		this.dao = dao;
	}

	public ReportDAO<V, K> getDAO()
	{
		return this.dao;
	}

	@Override
	public List<V> getReportData(K filter)
	{
		return dao.getReportData(filter);
	}
}