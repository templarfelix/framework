package io.easycm.framework.form.generator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Fernando on 16/12/2014.
 */
@JsonSerialize(include = Inclusion.NON_EMPTY)
public class FormlyFieldConfig implements Serializable {

  // key?: string;
  @Getter
  @Setter
  private String key;

  // id?: string;
  @Getter
  @Setter
  private String id;

  // templateOptions?: FormlyTemplateOptions;
  @Getter
  @Setter
  private FormlyTemplateOptions templateOptions = new FormlyTemplateOptions();

  // optionsTypes?: any;
  // FIXME TYAPR CORRETAMENTE
  @Getter
  @Setter
  private List<Object> optionsTypes;

  // FIXME TYAPR CORRETAMENTE
    /*
    validation?: {
        messages?: {
            [messageProperties: string]: string | Function;
        };
        show?: boolean;
        [additionalProperties: string]: any;
    };
    * */

  @Getter
  @Setter
  private Map<String, Object> validation;

  // validators?: any;
  //FIXME TYAPR CORRETAMENTE
  @Getter
  @Setter
  private Map<String, String> validators;

  // asyncValidators?: any;
  //FIXME TYAPR CORRETAMENTE
  @Getter
  @Setter
  private Map<String, String> asyncValidators;

  // template?: string;
  @Getter
  @Setter
  private String template;

  // component?: any;
  //FIXME TYAPR CORRETAMENTE
  @Getter
  @Setter
  private String component;

  // wrapper?: string[] | string;
  @Getter
  @Setter
  private List<String> wrapper;

  // wrappers?: string[];
  @Getter
  @Setter
  private List<String> wrappers;

  // fieldGroup?: Array<FormlyFieldConfig>;
  @Getter
  @Setter
  private List<FormlyFieldConfig> fieldGroup;

  // fieldArray?: FormlyFieldConfig;
  @Getter
  @Setter
  private List<FormlyFieldConfig> fieldArray;

  // hide?: boolean;
  @Getter
  @Setter
  private Boolean hide;

  // formControl?: AbstractControl;
  //FIXME TYAPR CORRETAMENTE
  @Getter
  @Setter
  private Object formControl;

  // hideExpression?: boolean | string | ((model: any, formState: any) => boolean);
  @Getter
  @Setter
  private String hideExpression;

  // className?: string;
  @Getter
  @Setter
  private String className;

  // type?: string;
  // FIXME TRANSFORMAR EM ENUM
  @Getter
  @Setter
  private String type;

  // expressionProperties?: any;
  //FIXME TYAPR CORRETAMENTE
  @Getter
  @Setter
  private Map<String, String> expressionProperties;

  // focus?: boolean;
  @Getter
  @Setter
  private Boolean focus;

  // modelOptions?: any;
  @Getter
  @Setter
  //FIXME TYAPR CORRETAMENTE
  private Object modelOptions;

  // lifecycle?: FormlyLifeCycleOptions;
  @Getter
  @Setter
  private FormlyLifeCycleOptions lifecycle;

  // defaultValue?: any;
  @Getter
  @Setter
  //FIXME TYAPR CORRETAMENTE
  private Object defaultValue;

  // parsers?: [(value: any, index: number) => {}];
  @Getter
  @Setter
  //FIXME TYAPR CORRETAMENTE
  private Object parsers;

}