package br.com.streamsoft.framework.base.entity.impl;

import br.com.streamsoft.framework.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;

/**
 *
 * */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class BaseEntityImpl<ID extends Serializable> implements
    BaseEntity<ID> {

  @Override
  public boolean entityIsNew() {
    return getId() == null;
  }

}
