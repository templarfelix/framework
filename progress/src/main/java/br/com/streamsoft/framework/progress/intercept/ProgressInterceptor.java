package br.com.streamsoft.framework.progress.intercept;

import br.com.streamsoft.framework.progress.annotation.ProgressMethod;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;

@ProgressMethod
@Interceptor
public class ProgressInterceptor implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@AroundInvoke
	public Object logMethodEntry(InvocationContext invocationContext)
			throws Exception
	{
		log.info("TESTE INTERCEPT PROGRESS");

		Object retorno = invocationContext.proceed();

		return retorno;
	}

}
