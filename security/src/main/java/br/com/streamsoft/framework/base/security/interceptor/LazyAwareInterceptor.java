package br.com.streamsoft.framework.base.security.interceptor;

import br.com.streamsoft.framework.base.lazy.LazyToNull;
import br.com.streamsoft.framework.base.security.LazyAware;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LazyAware
@Interceptor
/**
 * LazyAware Interceptor
 * Interceptor que valida coleções não carregadas
 *
 * */
public class LazyAwareInterceptor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private Logger log;

  @Inject
  private LazyToNull lazyToNull;

  @AroundInvoke
  public Object methodEntry(InvocationContext invocationContext)
      throws Exception {
    try {
      Object retorno = invocationContext.proceed();
      this.lazyToNull.setLazyToNull(retorno);
      return retorno;
    } finally {
    }
  }

}
