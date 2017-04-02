package io.eascycm.framework.security.filter;

import java.io.Serializable;

public class RoleFilterData implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String role;

  public RoleFilterData() {
  }

  public RoleFilterData(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}