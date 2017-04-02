package io.eascycm.framework.base.form;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Fernando on 15/12/2014.
 */

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormColumn {

  /**
   * Tipo de campo
   */
  FieldType type() default FieldType.AUTO;

  /**
   * Label do campo
   */
  String label() default "";

  /**
   * Campo obrigatório
   */
  boolean required() default true;

  /**
   *
   * */
  String placeholder() default "";

  /**
   *
   * */
  boolean disabled() default false;

  /**
   *
   * */
  String description() default "";

  /**
   * Expressão para esconder o campo
   */
  // FIXME TALVEZ NOVA INTERFACE
  String hideExpression() default "";

  // list control

  /**
   * Habilita o campo para filtro
   */
  boolean filter() default false;

  /**
   * Habilita o campo para aparecer no grid
   */
  boolean grid() default false;

}
