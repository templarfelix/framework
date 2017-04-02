package io.eascycm.framework.base.filter.impl;

import io.eascycm.framework.base.filter.CharacterEncodingFilter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filtro para forçar encoding UTF-8 em todas as requests.
 *
 * @author André Filippi Cardoso Farias
 */
public class CharacterEncodingFilterImpl implements CharacterEncodingFilter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }
}