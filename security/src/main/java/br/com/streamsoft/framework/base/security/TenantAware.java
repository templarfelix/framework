package br.com.streamsoft.framework.base.security;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Created by Fernando on 29/03/2016.
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface TenantAware {
}
