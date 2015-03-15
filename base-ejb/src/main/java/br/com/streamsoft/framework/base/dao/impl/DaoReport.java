package br.com.streamsoft.framework.base.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 *
 * */
public class DaoReport
{

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	/**
	 *
	 * */
	public List<Object> createNativeQuery(String sql)
	{
		return createNativeQuery(sql, null);
	}

	/**
	 *
	 * */
	public int createNativeQueryForUpdate(String sql)
	{
		return createNativeQueryForUpdate(sql, null);
	}

	/**
	 *
	 * */
	@SuppressWarnings("unchecked")
	public List<Object> createNativeQuery(String sql,
			HashMap<String, Object> params)
	{
		Query query = em.createNativeQuery(sql);
		setQueryParams(query, params);

		return query.getResultList();
	}

	/**
	 *
	 * */
	@SuppressWarnings("unchecked")
	public int createNativeQueryForUpdate(String sql,
			HashMap<String, Object> params)
	{
		Query query = em.createNativeQuery(sql);

		setQueryParams(query, params);

		return query.executeUpdate();
	}

	/**
	 * Cria uma query nativa com o tipo de resultado desejado e os parâmetros informados.
	 *
	 * @param sql    Query a ser executada.
	 * @param type   Tipo de objeto que deve ser retornado.
	 * @param params Parâmetros da query.
	 * @return A query parametrizada.
	 */
	@SuppressWarnings("rawtypes")
	public List getResultList(String sql, Class type, Map<String, Object> params)
	{
		Query query = em.createNativeQuery(sql, type);
		setQueryParams(query, params);

		return query.getResultList();
	}

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
