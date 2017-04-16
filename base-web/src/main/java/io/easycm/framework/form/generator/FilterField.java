package io.easycm.framework.form.generator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Fernando on 16/12/2014.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FilterField implements Serializable {

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