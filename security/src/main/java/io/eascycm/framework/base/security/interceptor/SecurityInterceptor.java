package io.eascycm.framework.base.security.interceptor;

import io.eascycm.framework.base.security.Security;
import io.eascycm.framework.security.facade.SecurityContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Security
@Interceptor
/**
 * Security Interceptor
 * Interceptor que valida as permissões do usuario
 *
 * */
public class SecurityInterceptor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private Logger log;

  @Inject
  private SecurityContext securityContext;

  @AroundInvoke
  public Object logMethodEntry(InvocationContext invocationContext)
      throws Exception {

    if (securityContext.getContext() == null) {
      throw new Exception("access denied");
    }

    if (invocationContext.getMethod().isAnnotationPresent(PermitAll.class)
        || invocationContext.getClass().isAnnotationPresent(
        PermitAll.class)) {
      // faz nada

    } else if (invocationContext.getMethod().isAnnotationPresent(
        DenyAll.class)
        || invocationContext.getClass().isAnnotationPresent(
        DenyAll.class)) {
      throw new Exception("access denied");

    } else if (invocationContext.getMethod().isAnnotationPresent(
        RolesAllowed.class)) {
      RolesAllowed rolesAnnotation = invocationContext.getMethod()
          .getAnnotation(RolesAllowed.class);
      Set<String> rolesSet = new HashSet<String>(
          Arrays.asList(rolesAnnotation.value()));
      boolean isOk = false;
      for (String str : rolesSet) {
        if (securityContext.getContext().isCallerInRole(str)) {
          isOk = true;
        }
      }

      if (!isOk) {
        throw new Exception("access denied");
      }
    }

    Object retorno = invocationContext.proceed();

    return retorno;
  }

}
