package br.com.streamsoft.framework.base.filter;

import br.com.streamsoft.framework.security.entity.LoggedUser;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface SecurityFilter extends Filter
{

	/* ATRIBUTOS DE SEGURANÇA */
	static String LOGIN_ATTRIBUTE_NAME = "LOGIN";
	static String LOGGED_USER_ATTRIBUTE_NAME = "LOGGED_USER";

	/**
	 * @param HttpServletRequest
	 * @return void
	 */
	void setUserParamSecurityContext(HttpServletRequest request);

	/**
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param ApplicationContext
	 * @return boolean
	 * @throws IOException
	 */
	boolean verifySecurityContext(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

	/**
	 * @param HttpServletRequest
	 * @param String
	 * @param String
	 * @return LoggedUser
	 */
	LoggedUser setLoggedUser(HttpServletRequest request,
			String checkLogin);

}