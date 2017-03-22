package br.com.streamsoft.framework.base.filter;


import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import java.util.List;
import java.util.Map;

/**
 * Interface que representa um filtro de relatório.
 *
 * @author André Filippi Cardoso Farias
 */
public interface FilterData<Q extends EntityPathBase<?>> {

  public Map<String, Object> getFilterData();

  public Predicate getParamsQ(Q entityPath);

  public List<Expression<?>> getJoinFetchQ(Q entityPath);

  public OrderSpecifier<?> getOrderByQ(Q entityPath);
}