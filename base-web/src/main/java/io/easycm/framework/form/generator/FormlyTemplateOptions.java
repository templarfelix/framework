package io.easycm.framework.form.generator;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Fernando on 03/04/2015.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FormlyTemplateOptions {

  // type?: string;
  @Getter
  @Setter
  private String type;
  // label?: string;
  @Getter
  @Setter
  private String label;
  // placeholder?: string;
  @Getter
  @Setter
  private String placeholder;
  // disabled?: Boolean;
  @Getter
  @Setter
  private Boolean disabled;
  @Getter
  @Setter
  private List<RadioOptions> options;
  // rows?: number;
  @Getter
  @Setter
  private Number rows;
  // cols?: number;
  @Getter
  @Setter
  private Number cols;
  // description?: string;
  @Getter
  @Setter
  private String description;
  // hidden?: boolean;
  @Getter
  @Setter
  private Boolean hidden;
  // max?: number;
  @Getter
  @Setter
  private Number max;
  // min?: number;
  @Getter
  @Setter
  private Long min;
  //  minLength?: number;
  @Getter
  @Setter
  private Number minLength;
  // maxLength?: number;
  @Getter
  @Setter
  private Number maxLength;
  // pattern?: string;
  @Getter
  @Setter
  private String pattern;
  // required?: Boolean;
  @Getter
  @Setter
  private Boolean required;
  // tabindex?: number;
  @Getter
  @Setter
  private Number tabIndex;
  // step?: number;
  @Getter
  @Setter
  private Number step;
  // focus?: Function;
  @Getter
  @Setter
  private String focus;
  // blur?: Function;
  @Getter
  @Setter
  private String blur;
  // keyup?: Function;
  @Getter
  @Setter
  private String keyup;
  // keydown?: Function;
  @Getter
  @Setter
  private String keydown;
  // click?: Function;
  @Getter
  @Setter
  private String click;
  // change?: Function;
  @Getter
  @Setter
  private String change;
  @Getter
  @Setter
  // keypress?: Function;
  private String keypress;
  // [additionalProperties: string]: any;
  // FIXME IMPLEMENTAR


}
