package io.easycm.framework.form.generator;

import java.io.Serializable;

/**
 * Created by Fernando on 16/12/2014.
 */
public class RadioOptions implements Serializable {

  private String name;
  private String value;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
