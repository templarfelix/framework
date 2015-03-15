package br.com.streamsoft.framework.base.entity;

import java.util.Collection;
import java.util.List;

/**
 * Interface mapeadora de resultSets de banco.
 * O método mapRows recebe uma lista crua do banco e a converte
 * numa coleção com os objetos desejados.
 *
 * @param <T> Tipo de objeto que deve ser retornado pela query.
 * @author André Cardoso
 */
public interface RowMapper<T>
{
	public Collection<T> mapRows(List<Object[]> resultSet);
}