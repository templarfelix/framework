package io.eascycm.framework.form.rest;

import io.eascycm.framework.base.entity.BaseEntity;
import io.eascycm.framework.base.form.FormColumn;
import io.eascycm.framework.base.rest.BaseREST;
import io.eascycm.framework.form.generator.ColumnField;
import io.eascycm.framework.form.generator.FilterField;
import io.eascycm.framework.form.generator.FormlyFieldConfig;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Fernando on 28/12/2014.
 */
public abstract class BaseFormRest<T extends BaseEntity> extends BaseREST {

  @Inject
  private Logger log;

  @GET
  @Path("/getFilter")
  @Produces(MediaType.APPLICATION_JSON)
  /**
   * */
  public List<FilterField> getFilter() {
    List<FilterField> filterFields = new ArrayList<FilterField>();

    Class current = getEntityClass();

    for (Field field : current.getDeclaredFields()) {
      if (field.isAnnotationPresent(FormColumn.class)) {
        // pega as informações da anotação
        FormColumn fieldInfoAnnotation = field
            .getAnnotation(FormColumn.class);
        if (fieldInfoAnnotation.filter()) {
          FilterField filterField = new FilterField();
          filterField.setName(fieldInfoAnnotation.label() + " | translate ");
          filterField.setKey(field.getName());
          filterField.setPlaceholder("(" + fieldInfoAnnotation.placeholder() + "| translate)");

          filterFields.add(filterField);
        }
      }
    }

    return filterFields;
  }

  @GET
  @Path("/getColumn")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ColumnField> getColumn() {
    List<ColumnField> columnFields = new ArrayList<ColumnField>();

    Class current = getEntityClass();

    for (Field field : current.getDeclaredFields()) {
      if (field.isAnnotationPresent(FormColumn.class)) {
        // pega as informações da anotação
        FormColumn fieldInfoAnnotation = field
            .getAnnotation(FormColumn.class);
        if (fieldInfoAnnotation.grid()) {
          ColumnField filterField = new ColumnField();
          filterField.setName("(" + fieldInfoAnnotation.label() + " | translate )");
          filterField.setKey(field.getName());
          filterField.setPlaceholder("(" + fieldInfoAnnotation.placeholder() + " | translate )");

          columnFields.add(filterField);
        }
      }
    }

    return columnFields;
  }

  @GET
  @Path("/getForm")
  @Produces(MediaType.APPLICATION_JSON)
  /**
   * FIXME finalizar a logica de montar campos
   * FIXME fazer a logica do campo auto e os demais
   * FIXME criar metodos para montar os campos privados facilitando chamar a logica
   *
   * */

  // FIXME REFATORAR PARA A VERSAO NOVA DO ANGLY
  // http://formly-js.github.io/angular-formly/#/
  //https://github.com/formly-js/angular-formly
  public List<FormlyFieldConfig> getForm() throws Exception {
    // make form
    List<FormlyFieldConfig> formlyFieldConfigs = new ArrayList<FormlyFieldConfig>();

    Class current = getEntityClass();

    for (Field field : current.getDeclaredFields()) {
      if (field.isAnnotationPresent(FormColumn.class)) {
        // pega as informações da anotação
        FormColumn fieldInfoAnnotation = field
            .getAnnotation(FormColumn.class);

        FormlyFieldConfig formlyFieldConfig = new FormlyFieldConfig();
        formlyFieldConfig.setClassName("form-group");
        formlyFieldConfig.setKey(field.getName());
        formlyFieldConfig.getTemplateOptions()
            .setLabel("(" + fieldInfoAnnotation.label() + " | translate )");

        //FIXME DESCONTINUADO ??
        //formlyFieldConfig.setDescription(fieldInfoAnnotation.description());
        //formlyFieldConfig.getTemplateOptions().setDisabled(fieldInfoAnnotation.disabled());

        // type by class
        if (field.getType().getName().equals("java.lang.String")) {
          makeTextField(formlyFieldConfig);
        } else if (field.getType().getName().equals("java.lang.Long")) {
          makeNumberField(formlyFieldConfig);
        } else if (field.getType().getName().equals("java.util.UUID")) {
          makeIdField(formlyFieldConfig);
        }

        // check JPA annotations for number
        // logicas para validar tamanho do campo

        if (field.isAnnotationPresent(Size.class)) {
          Size size = field.getAnnotation(Size.class);
          formlyFieldConfig.getTemplateOptions().setMax(Long.valueOf(size.max()));
          formlyFieldConfig.getTemplateOptions().setMin(Long.valueOf(size.min()));
        } else {
          if (field.isAnnotationPresent(Min.class)) {
            Min min = field.getAnnotation(Min.class);
            formlyFieldConfig.getTemplateOptions().setMin(min.value());
          }
          if (field.isAnnotationPresent(Max.class)) {
            Max max = field.getAnnotation(Max.class);
            formlyFieldConfig.getTemplateOptions().setMax(max.value());
          }
        }

        formlyFieldConfigs.add(formlyFieldConfig);
      }
    }
    // finish

    return formlyFieldConfigs;
  }

  /**
   * Cria campo do tipo {@link String}
   */
  private FormlyFieldConfig makeIdField(FormlyFieldConfig formlyFieldConfig) {
    formlyFieldConfig.setType("input");

    return formlyFieldConfig;
  }

  /**
   * Cria campo do tipo {@link String}
   */
  private FormlyFieldConfig makeTextField(FormlyFieldConfig formlyFieldConfig) {
    formlyFieldConfig.setType("input");

    return formlyFieldConfig;
  }

  /**
   * Cria campo do tipo {@link Number}
   */
  private FormlyFieldConfig makeNumberField(FormlyFieldConfig formlyFieldConfig) {
    formlyFieldConfig.setType("input");
    formlyFieldConfig.getTemplateOptions().setType("number");

    return formlyFieldConfig;
  }

  /**
   * get Entity Class Type
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  private Class<T> getEntityClass() {

    if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
      return (Class<T>) ((ParameterizedType) getClass()
          .getGenericSuperclass()).getActualTypeArguments()[0];
    } else if (getClass().getGenericSuperclass() instanceof Class) {
      Class c = (Class) getClass().getGenericSuperclass();
      return (Class<T>) ((ParameterizedType) c.getGenericSuperclass())
          .getActualTypeArguments()[0];
    }

    return (Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0];
  }

}
