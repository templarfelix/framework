package br.com.streamsoft.framework.base.dao.impl;

import br.com.streamsoft.framework.base.dao.ReportDAO;
import br.com.streamsoft.framework.base.entity.RowMapper;
import br.com.streamsoft.framework.base.filter.FilterData;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public abstract class ReportDaoImpl<V, K extends FilterData> implements ReportDAO<V, K>
{
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<V> getReportData(K filter)
	{
		Query query = em.createNativeQuery(getQuery(filter));
		setQueryParams(query, filter.getFilterData());
		List<Object[]> resultSet = query.getResultList();

		RowMapper<V> mapper = getRowMapper();
		List<V> result = (List<V>) mapper
				.mapRows(resultSet);

		return result;
	}

	@Override
	public abstract String getQuery(K filter);

	@Override
	public abstract RowMapper<V> getRowMapper();

	/**
	 * Popula os parâmetros da query.
	 *
	 * @param query  Query a ser parametrizada.
	 * @param params Parâmetros a serem adicionados à query.
	 */
	public void setQueryParams(Query query, Map<String, Object> params)
	{
		if (params != null)
		{
			Iterator<String> i = params.keySet().iterator();
			while (i.hasNext())
			{
				String key = (String) i.next();
				Object value = params.get(key);
				query.setParameter(key, value);
			}
		}
	}

}
