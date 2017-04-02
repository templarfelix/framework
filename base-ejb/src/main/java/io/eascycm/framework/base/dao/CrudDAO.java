package io.eascycm.framework.base.dao;

import io.eascycm.framework.base.dao.exception.DaoException;
import io.eascycm.framework.base.entity.BaseEntity;
import io.eascycm.framework.base.filter.FilterData;
import io.eascycm.framework.base.paging.DataPage;
import io.eascycm.framework.base.paging.Page;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 *
 * */
public interface CrudDAO<ID extends Serializable, T extends BaseEntity<ID>, Q extends EntityPathBase<T>>
    extends Serializable {

  /**
   *
   * */
  public T findById(ID id);

  /**
   *
   * */
  public T persist(T obj) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   *
   * */
  public void remove(T t) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   *
   * */
  public T merge(T obj) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   * Realiza uma busca no banco de dados usando a query informada,
   * retornando um registro único.
   *
   * @param hql Query a ser executada.
   * @return Objeto encontrado.
   */
  public T findSingle(String hql);

  /**
   * Realiza uma busca no banco de dados usando a query informada
   * com os parâmetros, retornando um registro único.
   *
   * @param hql Query a ser executada.
   * @param params Parâmetros da query.
   * @return Objeto encontrado.
   */
  public T findSingle(String hql, Map<String, Object> params);

  /**
   * Realiza uma busca no banco de dados usando a query informada.
   *
   * @param hql Query a ser executada.
   * @return Lista com os objetos encontrados
   */
  public List<T> find(String hql);

  /**
   * Realiza uma busca paginada no banco de dados usando a query informada.
   *
   * @param hql Query a ser executada.
   * @param countHql Query a ser executada para obter o count(*).
   * @param page Página a ser retornada.
   * @return Lista com os objetos encontrados
   */
  public DataPage<T> find(String hql, String countHql, Page page);

  /**
   * Realiza uma busca no banco de dados usando a query informada
   * com os parâmetros.
   *
   * @param hql Query a ser executada.
   * @param params Parâmetros da query.
   * @return Lista com os objetos encontrados
   */
  public List<T> find(String hql, Map<String, Object> params);

  /**
   * Realiza uma busca paginada no banco de dados usando a query informada
   * com os parâmetros.
   *
   * @param hql Query a ser executada.
   * @param countHql Query a ser executada para obter o count(*).
   * @param params Parâmetros da query.
   * @param page Página a ser retornada.
   * @return Lista com os objetos encontrados
   */
  public DataPage<T> find(String hql, String countHql, Page page, Map<String, Object> params);

  /**
   *
   * */
  public List<T> findNamed(String namedQuery);

  /**
   *
   * */
  public DataPage<T> findNamed(String namedQuery, String namedCount, Page page);

  /**
   *
   * */
  public List<T> findListNamed(String namedQuery, Map<String, Object> params);

  /**
   *
   * */
  public DataPage<T> findListNamed(String namedQuery, String namedCount, Page page,
      Map<String, Object> params);

  /**
   *
   * */
  public T findNamed(String namedQuery, Map<String, Object> params);

  /**
   * Realiza uma busca por um item utilizando criteria.
   */
  public T find(CriteriaQuery<T> criteriaQuery);

  /**
   * Realiza uma busca parametrizada por um item utilizando criteria.
   */
  public T find(CriteriaQuery<T> criteriaQuery, Map<String, Object> params);

  /**
   * Realiza uma busca por uma lista de itens utilizando criteria.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery);

  /**
   * Realiza uma busca parametrizada por uma lista de itens utilizando criteria.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery, Map<String, Object> params);

  /**
   * Realiza uma busca por uma lista de itens limitada utilizando criteria.
   *
   * @param criteriaQuery Query a ser executada.
   * @param limit Limite de registros retornados.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery, Integer limit);

  /**
   * Realiza uma busca parametrizada por uma lista de itens limitada utilizando criteria.
   *
   * @param criteriaQuery Query a ser executada.
   * @param limit Limite de registros retornados.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery, Map<String, Object> params,
      Integer limit);

  /**
   * Realiza uma busca por uma lista de itens paginada utilizando criteria.
   */
  public DataPage<T> findList(CriteriaQuery<T> criteriaQuery, CriteriaQuery<Number> countQuery,
      Page page);

  /**
   * Realiza uma busca parametrizada por uma lista de itens paginada utilizando criteria.
   */
  public DataPage<T> findList(CriteriaQuery<T> criteriaQuery, CriteriaQuery<Number> countQuery,
      Page page, Map<String, Object> params);

  /**
   * Realiza uma busca padrão utilizando os dados de filtro informados.
   *
   * @param filter FilterData contendo os dados de pesquisa.
   * @param page Página da pesquisa.
   * @return Os dados da busca.
   */
  public DataPage<T> findByFilter(FilterData<Q> filter, Page page);

  /**
   * Realiza uma busca paginada no banco de dados usando os parâmetros informados.
   *
   * @param qEnt objeto query da entidade
   * @param builder lista de de parâmetros da query
   * @param page Página a ser retornada.
   * @param fetchAll Deseja fazar fetch nos registros
   * @return Lista com os objetos encontrados
   */
  public DataPage<T> findQ(Q qEnt, Predicate pred, Page page, List<Expression<?>> expLst);

  public DataPage<T> findQ(Q qEnt, Predicate pred, Page page, List<Expression<?>> expLst,
      OrderSpecifier<?>[] order);

  public DataPage<T> findQ(Q qEnt, Predicate pred, Page page, Expression<?> exp);

  public List<T> findQ(Q qEnt, Predicate pred, List<Expression<?>> expLst);

  public DataPage<T> findQ(Q qEnt, FilterData<Q> filter, Page page);

  public List<T> findQ(Q qEnt, FilterData<Q> filter);

  public T findSingleQ(Q qEnt, FilterData<Q> filter);

  public T findSingleQ(Q qEnt, Predicate pred, List<Expression<?>> expLst);

  public T findSingleQ(Q qEnt, Predicate pred, Expression<?> exp);

  /**
   * Executa o flush nos dados
   */
  public void flush();
}
