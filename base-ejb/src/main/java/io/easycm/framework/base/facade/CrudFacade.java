package io.easycm.framework.base.facade;

import io.easycm.framework.base.dao.CrudDAO;
import io.easycm.framework.base.dao.exception.DaoException;
import io.easycm.framework.base.entity.BaseEntity;
import io.easycm.framework.base.filter.FilterData;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import com.querydsl.core.types.dsl.EntityPathBase;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

public interface CrudFacade<ID extends Serializable, T extends BaseEntity<ID>, Q extends EntityPathBase<T>>
    extends Serializable {

  /**
   *
   * */
  public T findById(ID id);

  /**
   *
   * */
  public T persist(T t) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   *
   */
  public T save(T t) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   *
   * */
  public void remove(T t) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   *
   * */
  public T merge(T t) throws ValidationException, ConstraintViolationException, DaoException;

  /**
   * {@link CrudDAO#findSingle(String)}
   */
  public T findSingle(String hql);

  /**
   * {@link CrudDAO#findSingle(String, Map)}
   */
  public T findSingle(String hql, Map<String, Object> params);

  /**
   * {@link CrudDAO#find(String)}
   */
  public List<T> find(String hql);

  /**
   * {@link CrudDAO#find(String, String, Page)}
   */
  public DataPage<T> find(String hql, String countHql, Page page);

  /**
   * {@link CrudDAO#find(String, Map)}
   */
  public List<T> find(String hql, Map<String, Object> params);

  /**
   * {@link CrudDAO#find(String, String, Map)}
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
   * Realiza uma busca por uma lista de itens limitada utilizando criteria.
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
   * Realiza uma busca por uma lista de itens paginada utilizando criteria.
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
   * Executa o flush nos dados
   */
  public void flush();

}
