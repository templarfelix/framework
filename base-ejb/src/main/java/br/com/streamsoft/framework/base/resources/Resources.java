package br.com.streamsoft.framework.base.resources;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Esta classe utiliza CDI para criar aliases de recursos do Java EE nos
 * beans CDI.
 * <p/>
 * <p>
 * Exemplo de injeção de um managed bean:
 * </p>
 * <p/>
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
public class Resources {

  //@Produces
  //@PersistenceContext(unitName = "primary")
  //@Default
  //@Any
  //private EntityManager em;

  //public void closeEntityManager(@Disposes EntityManager em) {
  //   em.close();
  //}

  /**
   * Obtém o logger.
   */
  @Produces
  public Logger produceLog(InjectionPoint injectionPoint) {
    return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
  }

  //
  private static MetricRegistry metricRegistry = new MetricRegistry();

  @Produces
  @ApplicationScoped
  private MetricRegistry producesMetricRegistry() {
    return metricRegistry;
  }

  public static MetricRegistry getMetricRegistry() {
    return metricRegistry;
  }

  //
  private static HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();

  @Produces
  @ApplicationScoped
  private HealthCheckRegistry producesHealthCheckRegistry() {
    return new HealthCheckRegistry();
  }

  public static HealthCheckRegistry getHealthCheckRegistry() {
    return healthCheckRegistry;
  }
}
