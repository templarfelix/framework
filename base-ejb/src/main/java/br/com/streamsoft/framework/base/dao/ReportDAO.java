package br.com.streamsoft.framework.base.dao;

import br.com.streamsoft.framework.base.entity.RowMapper;
import br.com.streamsoft.framework.base.filter.FilterData;

import java.io.Serializable;
import java.util.List;

/**
 * DAO padrão para telas de relatório.
 */
public interface ReportDAO<V, K extends FilterData>
		extends Serializable
{

	/**
	 * Realiza busca no banco de dados de acordo com o filtro especificado.
	 */
	public List<V> getReportData(K filter);

	/**
	 * Obtém a query principal do relatório.
	 */
	public String getQuery(K filter);

	/**
	 * Obtém o rowMapper utilizado para mapear o resultSet em DTOs.
	 */
	public RowMapper<V> getRowMapper();

}