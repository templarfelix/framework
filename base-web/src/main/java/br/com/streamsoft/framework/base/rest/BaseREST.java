package br.com.streamsoft.framework.base.rest;

import br.com.streamsoft.framework.security.entity.LoggedUser;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 *
 * */
public class BaseREST
{

	protected final int CREATE = 1;
	protected final int UPDATE = 2;
	protected final int DELETE = 3;
	protected final int READ = 4;
	@Inject
	private Logger log;
	@Context
	private HttpServletRequest httpServletRequest;
	@Context
	private HttpServletResponse httpServletResponse;

	/**
	 *
	 * */
	public LoggedUser getLoggedUser()
	{
		System.out.println("httpServletRequest" + httpServletRequest);
		System.out.println("httpServletRequest.getSession(false)"
				+ httpServletRequest.getSession(false));

		return (LoggedUser) httpServletRequest.getSession(false).getAttribute(
				"LOGGED_USER");
	}

	/**
	 *
	 * */
	public Response.ResponseBuilder createViolationResponse(
			Set<ConstraintViolation<?>> violations)
	{
		log.fine("Validation completed. violations found: " + violations.size());

		Map<String, String> responseObj = new HashMap<String, String>();

		for (ConstraintViolation<?> violation : violations)
		{
			responseObj.put(violation.getPropertyPath().toString(),
					violation.getMessage());
		}

		return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	}
}
