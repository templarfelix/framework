package io.eascycm.framework.base.resources;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

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
  @Singleton
  public MetricRegistry producesMetricRegistry() {
    return getMetricRegistry();
  }

  public static MetricRegistry getMetricRegistry() {
    return metricRegistry;
  }

  //
  private static HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();

  //https://cinhtau.net/wp/use-dropwizard-metrics-with-cdi-in-java-ee/
  @Produces
  @Singleton
  public HealthCheckRegistry producesHealthCheckRegistry() {
    return getHealthCheckRegistry();
  }

  public static HealthCheckRegistry getHealthCheckRegistry() {
    return healthCheckRegistry;
  }
}
