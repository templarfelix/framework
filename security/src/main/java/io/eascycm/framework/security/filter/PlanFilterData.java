package io.eascycm.framework.security.filter;

import java.io.Serializable;

public class PlanFilterData implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String name;

  public PlanFilterData() {
  }

  public PlanFilterData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}