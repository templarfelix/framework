package br.com.streamsoft.framework.base.security.interceptor;

import br.com.streamsoft.framework.base.security.Transactional;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.logging.Logger;

@Transactional
@Interceptor
/**
 * Created by Fernando.Silva on 11/09/2014.
 */
public class TransactionalInterceptor implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@Resource
	private UserTransaction userTransaction;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception
	{
		UserTransaction
				userTxn = userTransaction;

		//!em.getTransaction().isActive()
		log.info("TRANSACTION STATUS =" + userTxn.getStatus());
		boolean act = userTxn.getStatus() == 1;
		if (act)
		{
			userTxn.begin();
		}
		try
		{
			Object result = ic.proceed();
			if (act)
			{
				userTxn.commit();
			}
			return result;
		}
		catch (Exception e)
		{
			if (act)
			{
				userTxn.rollback();
			}
			throw e;
		}
	}

}
