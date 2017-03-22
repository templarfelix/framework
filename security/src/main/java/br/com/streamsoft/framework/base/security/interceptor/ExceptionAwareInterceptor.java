package br.com.streamsoft.framework.base.security.interceptor;

import br.com.streamsoft.framework.base.security.ExceptionAware;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@ExceptionAware
@Interceptor
/**
 * ExceptionAware Interceptor
 * Interceptor que valida erros no BackEnd
 *
 * */
public class ExceptionAwareInterceptor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private Logger log;

  @AroundInvoke
  public Object methodEntry(InvocationContext invocationContext)
      throws Exception {
    try {
      return invocationContext.proceed();
    } catch (Exception ex) {
      log.info(" **** ExceptionAwareINterceptor **** ");
      ex.printStackTrace();

      // TRATAR ERRO E ENVIAR PARA PAGINA DE ERROS

      throw new Exception(ex);
    } finally {
    }
  }

}
