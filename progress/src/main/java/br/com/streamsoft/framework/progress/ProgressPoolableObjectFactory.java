package br.com.streamsoft.framework.progress;

import br.com.streamsoft.framework.progress.config.ConfigManager;
import com.progress.open4gl.javaproxy.Connection;
import org.apache.commons.pool.PoolableObjectFactory;

/**
 * @author Fernando
 * @version 2.0
 */
public class ProgressPoolableObjectFactory implements PoolableObjectFactory
{

	static String appServerURL =
			"AppServer://" + ConfigManager.getParametro("appHost") + "/" + ConfigManager
					.getParametro("appServer");
	static String user = ConfigManager.getParametro("appUser");
	static String password = ConfigManager.getParametro("appPassword");
	static String appserverInfo = null;

	public ProgressPoolableObjectFactory()
	{
	}

	@Override
	public void activateObject(Object arg0) throws Exception
	{
	}

	@Override
	public void destroyObject(Object arg0) throws Exception
	{
		if (arg0 instanceof Connection)
		{
			Connection conn = (Connection) arg0;
			//conn.releaseConnection();
			conn.finalize();
		}
		arg0 = null;
	}

	@Override
	public Object makeObject() throws Exception
	{
		Connection conn = new Connection(appServerURL, user, password, appserverInfo);
		conn.setWaitIfBusy();
		conn.setSessionModel(0);

		return conn;
	}

	@Override
	public void passivateObject(Object arg0) throws Exception
	{
	}

	@Override
	public boolean validateObject(Object arg0)
	{
		return true;
	}

}
