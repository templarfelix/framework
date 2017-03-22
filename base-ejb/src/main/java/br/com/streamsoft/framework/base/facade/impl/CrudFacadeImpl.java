package br.com.streamsoft.framework.base.facade.impl;

import br.com.streamsoft.framework.base.dao.CrudDAO;
import br.com.streamsoft.framework.base.dao.exception.DaoException;
import br.com.streamsoft.framework.base.entity.BaseEntity;
import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.base.filter.FilterData;
import br.com.streamsoft.framework.base.paging.DataPage;
import br.com.streamsoft.framework.base.paging.Page;
import com.querydsl.core.types.dsl.EntityPathBase;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 *
 *
 * */
public class CrudFacadeImpl<ID extends Serializable, T extends BaseEntity<ID>, Q extends EntityPathBase<T>>
    implements CrudFacade<ID, T, Q> {

  private static final long serialVersionUID = 1L;

  private CrudDAO<ID, T, Q> dao;

  public CrudFacadeImpl(CrudDAO<ID, T, Q> dao) {
    this.dao = dao;
  }

  /**
   * Return currentDAO
   *
   * @return CrudDAO<ID, T>
   */
  public CrudDAO<ID, T, Q> getDAO() {
    return this.dao;
  }

  @Override
  public T findById(ID id) {
    return dao.findById(id);
  }

  @Override
  public T persist(T t) throws ValidationException, ConstraintViolationException, DaoException {
    return dao.persist(t);
  }

  @Override
  public T save(T t) throws ValidationException, ConstraintViolationException, DaoException {
    if (t.entityIsNew()) {
      return dao.persist(t);
    } else {
      return dao.merge(t);
    }
  }

  @Override
  public void remove(T t) throws ValidationException, ConstraintViolationException, DaoException {
    dao.remove(t);
  }

  @Override
  public T merge(T t) throws ValidationException, ConstraintViolationException, DaoException {
    return dao.merge(t);
  }

  /**
   * {@link CrudDAO#findSingle(String)}
   */
  @Override
  public T findSingle(String hql) {
    return dao.findSingle(hql);
  }

  /**
   * {@link CrudDAO#findSingle(String, Map)}
   */
  @Override
  public T findSingle(String hql, Map<String, Object> params) {
    return dao.findSingle(hql, params);
  }

  /**
   * {@link CrudDAO#find(String)}
   */
  @Override
  public List<T> find(String hql) {
    return dao.find(hql);
  }

  /**
   * {@link CrudDAO#find(String, Page)}
   */
  public DataPage<T> find(String hql, String countHql, Page page) {
    return dao.find(hql, countHql, page);
  }

  /**
   * {@link CrudDAO#find(String, Map)}
   */
  @Override
  public List<T> find(String hql, Map<String, Object> params) {
    return dao.find(hql, params);
  }

  /**
   * {@link CrudDAO#find(String, Map, Page)}
   */
  public DataPage<T> find(String hql, String countHql, Page page,
      Map<String, Object> params) {
    return dao.find(hql, countHql, page, params);
  }

  @Override
  public List<T> findNamed(String namedQuery) {
    return dao.findNamed(namedQuery);
  }

  @Override
  public DataPage<T> findNamed(String namedQuery, String namedCount, Page page) {
    return dao.findNamed(namedQuery, namedCount, page);
  }

  public List<T> findListNamed(String namedQuery, Map<String, Object> params) {
    return dao.findListNamed(namedQuery, params);
  }

  public DataPage<T> findListNamed(String namedQuery, String namedCount,
      Page page, Map<String, Object> params) {
    return dao.findListNamed(namedQuery, namedCount, page, params);
  }

  @Override
  public T findNamed(String namedQuery, Map<String, Object> params) {
    return dao.findNamed(namedQuery, params);
  }

  /**
   * Realiza uma busca por um item utilizando criteria.
   */
  public T find(CriteriaQuery<T> criteriaQuery) {
    return dao.find(criteriaQuery);
  }

  /**
   * Realiza uma busca parametrizada por um item utilizando criteria.
   */
  public T find(CriteriaQuery<T> criteriaQuery, Map<String, Object> params) {
    return dao.find(criteriaQuery, params);
  }

  /**
   * Realiza uma busca por uma lista de itens utilizando criteria.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery) {
    return dao.findList(criteriaQuery);
  }

  /**
   * Realiza uma busca parametrizada por uma lista de itens utilizando
   * criteria.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery,
      Map<String, Object> params) {
    return dao.findList(criteriaQuery, params);
  }

  /**
   * Realiza uma busca por uma lista de itens limitada utilizando criteria.
   *
   * @param criteriaQuery Query a ser executada.
   * @param limit Limite de registros retornados.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery, Integer limit) {
    return dao.findList(criteriaQuery, limit);
  }

  /**
   * Realiza uma busca parametrizada por uma lista de itens limitada
   * utilizando criteria.
   *
   * @param criteriaQuery Query a ser executada.
   * @param params Parâmetros nomeados da query.
   * @param limit Limite de registros retornados.
   */
  public List<T> findList(CriteriaQuery<T> criteriaQuery,
      Map<String, Object> params, Integer limit) {
    return dao.findList(criteriaQuery, params, limit);
  }

  /**
   * Realiza uma busca por uma lista de itens paginada utilizando criteria.
   */
  public DataPage<T> findList(CriteriaQuery<T> criteriaQuery,
      CriteriaQuery<Number> countQuery, Page page) {
    return dao.findList(criteriaQuery, countQuery, page);
  }

  /**
   * Realiza uma busca parametrizada por uma lista de itens paginada
   * utilizando criteria.
   */
  public DataPage<T> findList(CriteriaQuery<T> criteriaQuery,
      CriteriaQuery<Number> countQuery, Page page,
      Map<String, Object> params) {
    return dao.findList(criteriaQuery, countQuery, page, params);
  }

  public DataPage<T> findByFilter(FilterData<Q> filter, Page page) {
    throw new UnsupportedOperationException("Este método deve ser implementado pela classe filha");
  }

  /**
   * Executa o flush nos dados
   */
  public void flush() {
    dao.flush();
  }
}
