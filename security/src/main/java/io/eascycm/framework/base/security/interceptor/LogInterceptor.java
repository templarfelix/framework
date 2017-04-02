package io.eascycm.framework.base.security.interceptor;

import io.eascycm.framework.base.security.Log;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
/**
 * Interceptor que loga informações dos usuários
 * */
public class LogInterceptor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private Logger log;

  private boolean logEnable = false;

  @AroundInvoke
  public Object info(InvocationContext invocationContext)
      throws Exception {

    //Validar qunado habilitar o log por parametro

    if (logEnable) {
      //FIXME ADICOINAR USUARIO QUANDO POSSUIR O MESMO
      log.info("\n        User: " + "programador" +
          "\n  run method: " + invocationContext.getMethod().getName() +
          "\n in    class: " + invocationContext.getMethod().getDeclaringClass().getName() +
          "\n with params: " + invocationContext.getParameters().toString() +
          "\n with return: " + invocationContext.getMethod().getGenericReturnType() +
          "\n");

    }
    return invocationContext.proceed();
  }

}
