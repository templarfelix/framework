package io.easycm.framework.base.dao.impl;

import io.easycm.framework.base.dao.CrudDAO;
import io.easycm.framework.base.dao.exception.DaoException;
import io.easycm.framework.base.entity.impl.BaseEntityImpl;
import io.easycm.framework.base.filter.FilterData;
import io.easycm.framework.base.paging.DataPage;
import io.easycm.framework.base.paging.Page;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * CrudDaoImpl
 */
public abstract class CrudDAOImpl<ID extends Serializable, T extends BaseEntityImpl<ID>, Q extends EntityPathBase<T>>
    implements CrudDAO<ID, T, Q> {

  private static final long serialVersionUID = 1L;

  @Inject
  private EntityManager em;

  @Inject
  private Event<T> event;

  /**
   * Find Entity By ID
   *
   * @return T
   */
  @Override
  public T findById(ID id) {
    return (T) em.find(getEntityClass(), id);
  }

  /**
   * Persist Entity
   *
   * @return T
   */
  @Override
  public T persist(T obj) throws ValidationException, ConstraintViolationException, DaoException {
    try {
      em.persist(obj);
      event.fire(obj);
    } catch (ConstraintViolationException ce) {
      throw ce;
    } catch (ValidationException v) {
      throw v;
    } catch (Exception e) {
      throw new DaoException(e.getMessage());
    }
    return obj;
  }

  /**
   * Remove Entity
   *
   * @return void
   */
  public void remove(T t) throws ValidationException, ConstraintViolationException, DaoException {
    t = findById(t.getId());
    try {
      em.remove(t);
      event.fire(t);
    } catch (ConstraintViolationException ce) {
      throw ce;
    } catch (ValidationException v) {
      throw v;
    } catch (Exception e) {
      throw new DaoException(e.getMessage());
    }
  }

  /**
   * Merge Entity
   */
  @Override
  public T merge(T obj) throws ValidationException, ConstraintViolationException, DaoException {
    try {
      em.merge(obj);
      event.fire(obj);
    } catch (ConstraintViolationException ce) {
      throw ce;
    } catch (ValidationException v) {
      throw v;
    } catch (Exception e) {
      throw new DaoException(e.getMessage());
    }
    return obj;
  }

  /**
   * {@link CrudDAO#findSingle(String, Map)}
   */
  @SuppressWarnings("unchecked")
  @Override
  public T findSingle(String hql, Map<String, Object> params) {
    Query query = em.createQuery(hql);
    setQueryParams(query, params);

    return (T) query.getSingleResult();
  }

  /**
   * {@link CrudDAO#findSingle(String)}
   */
  @Override
  public T findSingle(String hql) {
    return findSingle(hql, null);
  }

  /**
   * {@link CrudDAO#find(String, Map)}
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<T> find(String hql, Map<String, Object> params) {
    Query query = em.createQuery(hql);
    setQueryParams(query, params);

    return query.getResultList();
  }

  /**
   * {@link CrudDAO#find(String)}
   */
  @Override
  public List<T> find(String hql) {
    return find(hql, null);
  }

  /**
   * {@link CrudDAO#find(String, String, Page, Map)}
   */
  @SuppressWarnings("unchecked")
  @Override
  public DataPage<T> find(String hql, String countHql, Page page,
      Map<String, Object> params) {
    Query query = em.createQuery(hql);
    setQueryParams(query, params);
    query.setFirstResult(page.getStartRow());
    query.setMaxResults(page.getPageSize());

    List<T> result = query.getResultList();
    Number count = getCountFind(countHql, params);

    DataPage<T> dataPage = new DataPage<T>(result, count, page);

    return dataPage;
  }

  /**
   * {@link CrudDAO#find(String, String, Page)}
   */
  @Override
  public DataPage<T> find(String hql, String countHql, Page page) {
    return find(hql, countHql, page, null);
  }

  /**
   * Find List of entities by Namedquery with params
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<T> findListNamed(String namedQuery, Map<String, Object> params) {
    Query query = em.createNamedQuery(namedQuery);
    setQueryParams(query, params);

    return query.getResultList();
  }

  /**
   * Find List Entities By NamedQuery
   *
   * @return List<T>
   */
  @Override
  public List<T> findNamed(String namedQuery) {
    return findListNamed(namedQuery, null);
  }

  /**
   * Find Paginated List of entities by Namedquery with params
   */
  @SuppressWarnings("unchecked")
  @Override
  public DataPage<T> findListNamed(String namedQuery, String namedCount,
      Page page, Map<String, Object> params) {
    Query query = em.createNamedQuery(namedQuery);
    setQueryParams(query, params);
    query.setFirstResult(page.getStartRow());
    query.setMaxResults(page.getPageSize());

    List<T> result = query.getResultList();
    Number count = getCountFindNamed(namedCount, params);

    DataPage<T> dataPage = new DataPage<T>(result, count, page);

    return dataPage;
  }

  /**
   * Find Paginated List Entities By NamedQuery
   *
   * @return List<T>
   */
  @Override
  public DataPage<T> findNamed(String namedQuery, String namedCount, Page page) {
    return findListNamed(namedQuery, namedCount, page, null);
  }

  /**
   * Find Entity by Namedquery with params
   */
  @SuppressWarnings("unchecked")
  @Override
  public T findNamed(String namedQuery, Map<String, Object> params) {
    Query query = em.createNamedQuery(namedQuery);
    setQueryParams(query, params);

    return (T) query.getSingleResult();
  }

  /**
   * get Entity Class Type
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public Class<T> getEntityClass() {

    if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
      return (Class<T>) ((ParameterizedType) getClass()
          .getGenericSuperclass()).getActualTypeArguments()[1];
    } else if (getClass().getGenericSuperclass() instanceof Class) {
      Class c = (Class) getClass().getGenericSuperclass();
      return (Class<T>) ((ParameterizedType) c.getGenericSuperclass())
          .getActualTypeArguments()[1];
    }

    return (Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[1];
  }

  /**
   * Popula os parâmetros da query.
   *
   * @param query Query a ser parametrizada.
   * @param params Parâmetros a serem adicionados à query.
   */
  private void setQueryParams(Query query, Map<String, Object> params) {
    if (params != null) {
      Iterator<String> i = params.keySet().iterator();
      while (i.hasNext()) {
        String key = (String) i.next();
        Object value = params.get(key);
        query.setParameter(key, value);
      }
    }
  }

  /**
   * Realiza uma busca por um item utilizando criteria.
   */
  @Override
  public T find(CriteriaQuery<T> criteriaQuery) {
    return find(criteriaQuery, null);
  }

  /**
   * Realiza uma busca parametrizada por um item utilizando criteria.
   */
  @Override
  public T find(CriteriaQuery<T> criteriaQuery, Map<String, Object> params) {
    TypedQuery<T> query = em.createQuery(criteriaQuery);
    setQueryParams(query, params);
    T obj = query.getSingleResult();
    return obj;
  }

  /**
   * Realiza uma busca por uma lista de itens utilizando criteria.
   */
  @Override
  public List<T> findList(CriteriaQuery<T> criteriaQuery) {
    return findList(criteriaQuery, new HashMap<String, Object>());
  }

  /**
   * Realiza uma busca parametrizada por uma lista de itens utilizando
   * criteria.
   */
  @Override
  public List<T> findList(CriteriaQuery<T> criteriaQuery,
      Map<String, Object> params) {
    TypedQuery<T> query = em.createQuery(criteriaQuery);
    setQueryParams(query, params);
    List<T> result = query.getResultList();
    return result;
  }

  /**
   * Realiza uma busca por uma lista de itens limitada utilizando criteria.
   *
   * @param criteriaQuery Query a ser executada.
   * @param limit Limite de registros retornados.
   */
  @Override
  public List<T> findList(CriteriaQuery<T> criteriaQuery, Integer limit) {
    return findList(criteriaQuery, null, limit);
  }

  /**
   * Realiza uma busca parametrizada por uma lista de itens limitada
   * utilizando criteria.
   *
   * @param criteriaQuery Query a ser executada.
   * @param params Parâmetros nomeados da query.
   * @param limit Limite de registros retornados.
   */
  @Override
  public List<T> findList(CriteriaQuery<T> criteriaQuery,
      Map<String, Object> params, Integer limit) {
    TypedQuery<T> query = em.createQuery(criteriaQuery);
    query.setMaxResults(limit);
    setQueryParams(query, params);
    List<T> result = query.getResultList();
    return result;
  }

  /**
   * Realiza uma busca por uma lista de itens paginada utilizando criteria.
   */
  @Override
  public DataPage<T> findList(CriteriaQuery<T> criteriaQuery,
      CriteriaQuery<Number> countQuery, Page page) {
    return findList(criteriaQuery, countQuery, page, null);
  }

  /**
   * Realiza uma busca parametrizada por uma lista de itens paginada
   * utilizando criteria.
   */
  @Override
  public DataPage<T> findList(CriteriaQuery<T> criteriaQuery,
      CriteriaQuery<Number> countQuery, Page page,
      Map<String, Object> params) {
    TypedQuery<T> query = em.createQuery(criteriaQuery);
    query.setFirstResult(page.getStartRow());
    query.setMaxResults(page.getPageSize());
    setQueryParams(query, params);

    List<T> result = query.getResultList();
    Number count = em.createQuery(countQuery).getSingleResult();

    DataPage<T> dataPage = new DataPage<T>(result, count, page);

    return dataPage;
  }

  public Number getCountFind(String hql) {
    Query query = em.createQuery(hql);

    return (Number) query.getSingleResult();
  }

  protected CriteriaBuilder getCriteriaBuilder() {
    return em.getCriteriaBuilder();
  }

  protected CriteriaQuery<T> getCriteriaQuery() {
    return getCriteriaBuilder().createQuery(getEntityClass());
  }

  protected CriteriaQuery<Number> getCountCriteriaQuery() {
    return getCriteriaBuilder().createQuery(Number.class);
  }

  public Number getCountFind(String hql, Map<String, Object> params) {
    Query query = em.createQuery(hql);
    setQueryParams(query, params);

    return (Number) query.getSingleResult();
  }

  public Number getCountFindNamed(String namedQuery) {
    Query query = em.createNamedQuery(namedQuery);

    return (Number) query.getSingleResult();
  }

  public Number getCountFindNamed(String namedQuery,
      Map<String, Object> params) {
    Query query = em.createNamedQuery(namedQuery);
    setQueryParams(query, params);

    return (Number) query.getSingleResult();
  }

  public DataPage<T> findByFilter(FilterData<Q> filterData, Page page) {
    throw new UnsupportedOperationException(
        "Este método deve ser implementado pela classe filha");
  }

  public void flush() {
    em.flush();
  }

  protected JPAQueryBase from(EntityPath<?> entityPaths) {
    return new JPAQuery(em).from(entityPaths);
  }

  public DataPage<T> findQ(Q qEnt, Predicate pred, Page page, List<Expression<?>> expLst) {
    return findQ(qEnt, pred, page, expLst, null);
  }

  public DataPage<T> findQ(Q qEnt, Predicate pred, Page page, List<Expression<?>> expLst,
      OrderSpecifier<?>[] order) {
    JPAQuery query = (JPAQuery) from(qEnt);

    setJoinFetchInQuery(query, expLst);

    query.where(pred);

    query.offset(page.getStartRow());
    query.limit(page.getPageSize());

    if (order != null) {
      query.orderBy(order);
    }

    List<T> result = query.fetch();
    Number count = query.fetchCount();

    DataPage<T> dataPage = new DataPage<T>(result, count, page);

    return dataPage;
  }

  public DataPage<T> findQ(Q qEnt, Predicate pred, Page page, Expression<?> exp) {
    List<Expression<?>> expLst = new ArrayList<Expression<?>>();

    if (exp != null) {
      expLst.add(exp);
    }

    return findQ(qEnt, pred, page, expLst);
  }

  public List<T> findQ(Q qEnt, Predicate pred, List<Expression<?>> expLst) {
    JPAQuery query = (JPAQuery) from(qEnt);

    setJoinFetchInQuery(query, expLst);

    query.where(pred);

    List<T> result = query.fetch();

    return result;
  }

  public DataPage<T> findQ(Q qEnt, FilterData<Q> filter, Page page) {
    JPAQuery query = (JPAQuery) from(qEnt);

    setJoinFetchInQuery(query, filter.getJoinFetchQ(qEnt));

    query.where(filter.getParamsQ(qEnt));

    query.offset(page.getStartRow());
    query.limit(page.getPageSize());

    if (filter.getOrderByQ(qEnt) != null) {
      query.orderBy(filter.getOrderByQ(qEnt));
    }

    List<T> result = query.fetch();
    Number count = query.fetchCount();

    DataPage<T> dataPage = new DataPage<T>(result, count, page);

    return dataPage;
  }

  public List<T> findQ(Q qEnt, FilterData<Q> filter) {
    JPAQuery query = (JPAQuery) from(qEnt);

    setJoinFetchInQuery(query, filter.getJoinFetchQ(qEnt));

    query.where(filter.getParamsQ(qEnt));

    if (filter.getOrderByQ(qEnt) != null) {
      query.orderBy(filter.getOrderByQ(qEnt));
    }

    return query.fetch();
  }

  public T findSingleQ(Q qEnt, FilterData<Q> filter) {
    JPAQuery query = (JPAQuery) from(qEnt);

    setJoinFetchInQuery(query, filter.getJoinFetchQ(qEnt));

    query.where(filter.getParamsQ(qEnt));

    if (filter.getOrderByQ(qEnt) != null) {
      query.orderBy(filter.getOrderByQ(qEnt));
    }

    T result = (T) query.fetchOne();

    return result;
  }

  public T findSingleQ(Q qEnt, Predicate pred, List<Expression<?>> expLst) {
    JPAQuery query = (JPAQuery) from(qEnt);

    setJoinFetchInQuery(query, expLst);

    query.where(pred);

    T result = (T) query.fetchFirst();

    return result;
  }

  public T findSingleQ(Q qEnt, Predicate pred, Expression<?> exp) {
    List<Expression<?>> expLst = new ArrayList<Expression<?>>();

    if (exp != null) {
      expLst.add(exp);
    }

    return findSingleQ(qEnt, pred, expLst);

  }

  private void setJoinFetchInQuery(JPAQuery query, List<Expression<?>> expLst) {
    if (expLst != null) {
      for (Expression<?> exp : expLst) {
        if (exp instanceof EntityPath<?>) {
          query.leftJoin((EntityPath<?>) exp).fetchJoin();
        }
        if (exp instanceof CollectionExpression<?, ?>) {
          query.leftJoin((CollectionExpression<?, ?>) exp).fetchJoin();
        }
      }
    }
  }
}