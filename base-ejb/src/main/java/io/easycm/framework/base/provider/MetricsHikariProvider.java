package io.easycm.framework.base.provider;

import io.easycm.framework.base.resources.Resources;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.hikaricp.internal.HikariConfigurationUtil;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.Stoppable;
import org.jboss.logging.Logger;

/**
 * Created by felix on 14/03/2017.
 */
public class MetricsHikariProvider implements ConnectionProvider, Configurable, Stoppable {

  private static final long serialVersionUID = -9131625057941275711L;
  private static final Logger LOGGER = Logger.getLogger(MetricsHikariProvider.class);
  private HikariConfig hcfg = null;
  private HikariDataSource hds = null;

  public MetricsHikariProvider() {
  }

  public void configure(Map props) throws HibernateException {
    try {
      LOGGER.debug("Configuring MetricsHikariProvider");
      this.hcfg = HikariConfigurationUtil.loadConfiguration(props);
      this.hds = new HikariDataSource(this.hcfg);
      this.hds.setHealthCheckRegistry(Resources.getHealthCheckRegistry());
      this.hds.setMetricRegistry(Resources.getMetricRegistry());
    } catch (Exception var3) {
      throw new HibernateException(var3);
    }

    LOGGER.debug("HikariCP MetricsHikariProvider");
  }

  public Connection getConnection() throws SQLException {
    Connection conn = null;
    if (this.hds != null) {
      conn = this.hds.getConnection();
    }

    return conn;
  }

  public void closeConnection(Connection conn) throws SQLException {
    conn.close();
  }

  public boolean supportsAggressiveRelease() {
    return false;
  }

  public boolean isUnwrappableAs(Class unwrapType) {
    return ConnectionProvider.class.equals(unwrapType) || MetricsHikariProvider.class
        .isAssignableFrom(unwrapType) || DataSource.class.isAssignableFrom(unwrapType);
  }

  public <T> T unwrap(Class<T> unwrapType) {
    if (!ConnectionProvider.class.equals(unwrapType) && !MetricsHikariProvider.class
        .isAssignableFrom(unwrapType)) {
      if (DataSource.class.isAssignableFrom(unwrapType)) {
        return (T) this.hds;
      } else {
        throw new UnknownUnwrapTypeException(unwrapType);
      }
    } else {
      return (T) this;
    }
  }

  public void stop() {
    this.hds.shutdown();
  }
}
