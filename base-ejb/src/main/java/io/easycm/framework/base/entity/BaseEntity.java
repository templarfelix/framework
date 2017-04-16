package io.easycm.framework.base.entity;

import java.io.Serializable;
import javax.persistence.Transient;

public interface BaseEntity<ID> extends Serializable {

  @Transient
  public abstract ID getId();

  public abstract void setId(ID id);

  public boolean entityIsNew();

}
