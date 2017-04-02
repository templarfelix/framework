package io.eascycm.framework.form.generator;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Fernando on 16/12/2014.
 */
// TODO REFATORAR PARA MAIS NECESSIDADES
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ColumnField implements Serializable {

  @Getter
  @Setter
  private String key;
  @Getter
  @Setter
  private String placeholder;
  @Getter
  @Setter
  private String name;

}