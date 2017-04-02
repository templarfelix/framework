package io.eascycm.framework.security.filter;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.eascycm.framework.base.filter.FilterData;
import io.eascycm.framework.security.entity.QUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserFilterData implements FilterData<QUser> {

  public static final int BY_ID_ASC = 1;
  public static final int BY_ID_DESC = 2;
  private UUID id;
  private String email;
  private String name;
  private Integer orderBy;

  public UserFilterData() {
  }

  public UserFilterData(UUID id) {
    this.id = id;
  }

  public UserFilterData(String name) {
    this.name = name;
  }

  @Override
  public Map<String, Object> getFilterData() {
    Map<String, Object> filter = new HashMap<String, Object>();
    if (getId() != null) {
      filter.put("id", getId());
    }
    if (getName() != null) {
      filter.put("name", "%" + getName() + "%");
    }

    return filter;
  }

  @Override
  public Predicate getParamsQ(QUser user) {
    BooleanBuilder builder = new BooleanBuilder();

    if (id != null) {
      builder.and(user.id.eq(id));
    }
    if (name != null) {
      builder.and(user.name.containsIgnoreCase(name));
    }
    if (email != null) {
      builder.and(user.email.equalsIgnoreCase(email));
    }

    return builder;

  }

  @Override
  public List<Expression<?>> getJoinFetchQ(QUser user) {
    List<Expression<?>> fetchLst = new ArrayList<Expression<?>>();

    return fetchLst;
  }

  @Override
  public OrderSpecifier<?> getOrderByQ(QUser user) {
    if (orderBy == null) {
      return null;
    }

    switch (orderBy) {
      case BY_ID_ASC:
        return user.id.asc();
      case BY_ID_DESC:
        return user.id.desc();
      default:
        return null;
    }
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public void setOrderBy(Integer orderBy) {
    this.orderBy = orderBy;
  }
}