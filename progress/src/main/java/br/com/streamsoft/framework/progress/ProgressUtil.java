package br.com.streamsoft.framework.progress;

import br.com.streamsoft.framework.progress.config.ConfigManager;
import br.com.streamsoft.framework.progress.entity.RowErrors;
import com.progress.open4gl.ProResultSet;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.javaproxy.Connection;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Fernando
 *         Criado POOL de Conexőes Progress
 * @version 2.0
 */
public class ProgressUtil
{

	static Integer maxConnections = Integer.parseInt(ConfigManager.getParametro("appMaxConnection"));
	static Boolean useInstance = new Boolean(ConfigManager.getParametro("appUseInstance"));
	static ProgressUtil instance = null;
	@Inject
	private Logger logger;
	private GenericObjectPool pool = null;
	private List<ResultSetHolder> holders = new ArrayList<ResultSetHolder>();

	/**
	 * Construtor
	 */
	public ProgressUtil()
	{
		pool = new GenericObjectPool(new ProgressPoolableObjectFactory());
		pool.setTestOnBorrow(true);
		pool.setMaxActive(maxConnections);
		pool.setMaxIdle(GenericObjectPool.DEFAULT_MAX_IDLE);
		pool.setMinIdle(GenericObjectPool.DEFAULT_MIN_IDLE);
		pool.setMaxWait(GenericObjectPool.DEFAULT_MAX_WAIT);
		pool.setTimeBetweenEvictionRunsMillis(
				GenericObjectPool.DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS);
		pool.setMinEvictableIdleTimeMillis(GenericObjectPool.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS);
		pool.setWhenExhaustedAction(GenericObjectPool.DEFAULT_WHEN_EXHAUSTED_ACTION);
	}

	/**
	 *
	 * */
	private ProgressUtil getInstance()
	{
		if (instance == null)
		{
			instance = new ProgressUtil();
		}

		return instance;
	}

	/**
	 *
	 * */
	public ResultSetHolder createResultSetHolder() throws Exception
	{
		ResultSetHolder holder = new ResultSetHolder();
		holders.add(holder);
		return holder;
	}

	/**
	 *
	 * */
	public ProgressBeanResultSet createProgressBeanResultSet(ArrayList<ProgressBean> beans)
	{
		return new ProgressBeanResultSet(beans);
	}

	/**
	 *
	 * */
	public GregorianCalendar convertDateToGregorianCalendar(Date data)
	{
		GregorianCalendar dataReturn = new GregorianCalendar();
		dataReturn.setTime(data);
		return dataReturn;
	}

	/**
	 *
	 * */
	public Connection getConnection() throws Exception
	{
		if (useInstance)
		{
			return getInstance().getActualConnection();
		}
		else
		{
			return getActualConnection();
		}
	}

	private Connection getActualConnection() throws Exception
	{
		try
		{
			return (Connection) pool.borrowObject();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("Erro ao obter conexăo");
		}
	}

	public void invalidateConnection(Connection connection) throws Exception
	{
		if (useInstance)
		{
			getInstance().invalidateObject(connection);
			//getInstance().closeResultSets();
		}
		else
		{
			invalidateObject(connection);
			//closeResultSets();
		}
	}

	private void invalidateObject(Connection connection) throws Exception
	{
		try
		{
			//connection.releaseConnection();
			connection.finalize();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			pool.invalidateObject(connection);
		}
	}

	/**
	 * @param ResultSetHolder
	 * @return void
	 */
	public void checkRowErrors(ResultSetHolder rowErrors) throws Exception
	{

		try
		{
			RowErrors voError = null;
			ArrayList<RowErrors> resultErrors = new ArrayList<RowErrors>();
			for (ProResultSet prs = (ProResultSet) rowErrors.getResultSetValue();
				 prs.next();
				 resultErrors.add(voError))
			{
				voError = new RowErrors();
				voError.setData(prs);
			}

			resultErrors = deleteDefaultErrors(resultErrors);

			if (!resultErrors.isEmpty())
			{
				throw new ProgressException(resultErrors);
			}
		}
		catch (Exception e)
		{
			throw e;
		}

	}

	/**
	 * @param ArrayList<RowErrors>
	 * @return ArrayList<RowErrors>
	 */
	private ArrayList<RowErrors> deleteDefaultErrors(ArrayList<RowErrors> rowErrors)
	{
		for (int x = rowErrors.size() - 1; x >= 0; x--)
		{
			if (rowErrors.get(x).getErrorType().toUpperCase().equals("INTERNAL"))
			{
				logger.warning("Removendo Erro: " + rowErrors.get(x).getErrorDescription());
				rowErrors.remove(x);
			}
		}
		return rowErrors;
	}

	public void closeResultSets()
	{
		for (int i = 0; i < holders.size(); i++)
		{
			ResultSetHolder holder = holders.get(i);
			try
			{
				if (holder != null)
				{
					Object resultSet = holder.getResultSetValue();
					if (resultSet != null && resultSet instanceof ProResultSet)
					{
						((ProResultSet) resultSet).close();
					}
				}
			}
			catch (Exception e)
			{
				logger.warning("Erro ao rodar closeResultSets()" + e.getMessage());
			}
		}

	}

}
