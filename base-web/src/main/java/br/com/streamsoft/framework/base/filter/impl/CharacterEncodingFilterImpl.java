package br.com.streamsoft.framework.base.filter.impl;

import br.com.streamsoft.framework.base.filter.CharacterEncodingFilter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filtro para forçar encoding UTF-8 em todas as requests.
 *
 * @author André Filippi Cardoso Farias
 */
public class CharacterEncodingFilterImpl implements CharacterEncodingFilter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy()
	{
	}
}