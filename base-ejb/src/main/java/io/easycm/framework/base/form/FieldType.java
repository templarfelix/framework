package io.easycm.framework.base.form;

/**
 * Created by Fernando on 06/01/2015.
 */
public enum FieldType {

  AUTO("auto"),
  PASSSWORD("password"),
  INPUT("INPUT");

  private String type = "auto";

  FieldType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
