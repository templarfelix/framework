package io.easycm.framework.base.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 * Anotação do interceptor que ativa o controle de transações em banco de dados
 *
 * @author Fernando.Silva
 * @version 0.0.1
 * @since 3.3.0
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Transactional {

}
