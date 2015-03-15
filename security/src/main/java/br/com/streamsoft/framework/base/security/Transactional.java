package br.com.streamsoft.framework.base.security;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Anotação do interceptor que ativa o controle de transações em banco de dados
 *
 * @author Fernando.Silva
 * @since 3.3.0
 * @version 0.0.1
 * */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Transactional
{

}
