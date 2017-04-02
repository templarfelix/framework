package io.eascycm.framework.security.filter;

import io.eascycm.framework.base.filter.FilterData;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.eascycm.framework.security.entity.QTenant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TenantFilterData implements FilterData<QTenant> {

  public static final int BY_NAME_ASC = 1;
  public static final int BY_NAME_DESC = 2;

  private String name;

  private Integer orderBy;

  public TenantFilterData() {

  }

  public TenantFilterData(String name) {
    setName(name);
  }

  @Override
  public Map<String, Object> getFilterData() {
    Map<String, Object> filter = new HashMap<String, Object>();
    if (getName() != null && !getName().isEmpty()) {
      filter.put("name", getName());
    }
    return filter;
  }

  @Override
  public Predicate getParamsQ(QTenant entity) {
    BooleanBuilder builder = new BooleanBuilder();

    if (getName() != null && !getName().isEmpty()) {
      builder.and(entity.name.eq(getName()));
    }

    return builder;

  }

  @Override
  public List<Expression<?>> getJoinFetchQ(QTenant entity) {

    List<Expression<?>> fetchLst = new ArrayList<Expression<?>>();

    return fetchLst;
  }

  @Override
  public OrderSpecifier<?> getOrderByQ(QTenant entity) {
    if (orderBy == null) {
      return null;
    }

    switch (orderBy) {
      case BY_NAME_ASC:
        return entity.name.asc();
      case BY_NAME_DESC:
        return entity.name.desc();
      default:
        return null;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getOrderBy() {
    return orderBy;
  }
}
