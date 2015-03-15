package br.com.streamsoft.framework.base.facade;

import br.com.streamsoft.framework.base.filter.FilterData;

import java.io.Serializable;
import java.util.List;

/**
 * Façade padrão para telas de relatório.
 */
public interface ReportFacade<V, K extends FilterData>
		extends Serializable
{

	/**
	 * Realiza busca no banco de dados de acordo com o filtro especificado.
	 */
	public List<V> getReportData(K filter);
}