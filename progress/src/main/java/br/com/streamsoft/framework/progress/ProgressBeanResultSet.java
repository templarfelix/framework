package br.com.streamsoft.framework.progress;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Fernando
 * @version 2.0
 */
public class ProgressBeanResultSet implements ResultSet
{

	private ProgressBean tempbean;

	private ProgressBean bean;

	private ArrayList<ProgressBean> beans;

	@SuppressWarnings("rawtypes")
	private Iterator iter;

	public ProgressBeanResultSet(ArrayList<ProgressBean> beans)
	{
		this.beans = beans;
	}

	public ProgressBeanResultSet(ProgressBean bean)
	{
		this.bean = bean;
	}

	public boolean absolute(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void afterLast() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void beforeFirst() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void cancelRowUpdates() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void clearWarnings() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void close() throws SQLException
	{
		this.bean = null;
		// throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void deleteRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int findColumn(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean first() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Array getArray(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Array getArray(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public InputStream getAsciiStream(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public InputStream getAsciiStream(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public BigDecimal getBigDecimal(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public BigDecimal getBigDecimal(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public InputStream getBinaryStream(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public InputStream getBinaryStream(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Blob getBlob(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Blob getBlob(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean getBoolean(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean getBoolean(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public byte getByte(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public byte getByte(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public byte[] getBytes(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public byte[] getBytes(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Reader getCharacterStream(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Reader getCharacterStream(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Clob getClob(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Clob getClob(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getConcurrency() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public String getCursorName() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Date getDate(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Date getDate(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Date getDate(int arg0, Calendar arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Date getDate(String arg0, Calendar arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public double getDouble(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public double getDouble(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getFetchDirection() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void setFetchDirection(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getFetchSize() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void setFetchSize(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public float getFloat(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public float getFloat(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getHoldability() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getInt(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getInt(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public long getLong(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public long getLong(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public ResultSetMetaData getMetaData() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Reader getNCharacterStream(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Reader getNCharacterStream(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	/*
	 * public NClob getNClob(int arg0) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public NClob getNClob(String arg0) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 */
	public String getNString(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public String getNString(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Object getObject(int arg0) throws SQLException
	{
		return this.tempbean.getField(arg0);
	}

	public Object getObject(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Ref getRef(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Ref getRef(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	/*
	 * public RowId getRowId(int arg0) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public RowId getRowId(String arg0) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public SQLXML getSQLXML(int arg0) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public SQLXML getSQLXML(String arg0) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 */
	public short getShort(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public short getShort(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Statement getStatement() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public String getString(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public String getString(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Time getTime(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Time getTime(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Time getTime(int arg0, Calendar arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Time getTime(String arg0, Calendar arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Timestamp getTimestamp(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Timestamp getTimestamp(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public int getType() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public URL getURL(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public URL getURL(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public InputStream getUnicodeStream(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public InputStream getUnicodeStream(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public SQLWarning getWarnings() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void insertRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean isAfterLast() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean isBeforeFirst() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean isClosed() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean isFirst() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean isLast() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean last() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void moveToCurrentRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void moveToInsertRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean next() throws SQLException
	{
		if (this.beans == null)
		{
			if (this.tempbean == null)
			{
				this.tempbean = this.bean;
				return true;
			}
			return false;
		}
		if (this.iter == null)
		{
			this.iter = beans.iterator();
		}
		if (iter.hasNext())
		{
			this.tempbean = (ProgressBean) iter.next();
			return true;
		}
		return false;
	}

	public boolean previous() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void refreshRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean relative(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean rowDeleted() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean rowInserted() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean rowUpdated() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateArray(int arg0, Array arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateArray(String arg0, Array arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBlob(int arg0, Blob arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBlob(String arg0, Blob arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBoolean(int arg0, boolean arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBoolean(String arg0, boolean arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateByte(int arg0, byte arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateByte(String arg0, byte arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBytes(int arg0, byte[] arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateBytes(String arg0, byte[] arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateClob(int arg0, Clob arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateClob(String arg0, Clob arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateDate(int arg0, Date arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateDate(String arg0, Date arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateDouble(int arg0, double arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateDouble(String arg0, double arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateFloat(int arg0, float arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateFloat(String arg0, float arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateInt(int arg0, int arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateInt(String arg0, int arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateLong(int arg0, long arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateLong(String arg0, long arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateNString(int arg0, String arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateNString(String arg0, String arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateNull(int arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateNull(String arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateObject(int arg0, Object arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateObject(String arg0, Object arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateObject(int arg0, Object arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateObject(String arg0, Object arg1, int arg2) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateRef(int arg0, Ref arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateRef(String arg0, Ref arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateRow() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	/*
	 * public void updateRowId(int arg0, RowId arg1) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public void updateRowId(String arg0, RowId arg1) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 *
	 * public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException { throw new SQLException("Metodo n�o implementado no result set!"); }
	 */
	public void updateShort(int arg0, short arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateShort(String arg0, short arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateString(int arg0, String arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateString(String arg0, String arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateTime(int arg0, Time arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateTime(String arg0, Time arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean wasNull() throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public boolean isWrapperFor(Class<?> arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException
	{
		throw new SQLException("Metodo n�o implementado no result set!");
	}

	public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException
	{
	}

	public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException
	{
	}

	public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException
	{
	}

	public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException
	{
	}

	public void updateBlob(int arg0, InputStream arg1) throws SQLException
	{
	}

	public void updateBlob(String arg0, InputStream arg1) throws SQLException
	{
	}

	public void updateCharacterStream(int arg0, Reader arg1) throws SQLException
	{
	}

	public void updateCharacterStream(String arg0, Reader arg1) throws SQLException
	{
	}

	public void updateClob(int arg0, Reader arg1) throws SQLException
	{
	}

	public void updateClob(String arg0, Reader arg1) throws SQLException
	{
	}

	public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException
	{
	}

	public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException
	{
	}

	public void updateNClob(int arg0, Reader arg1) throws SQLException
	{
	}

	public void updateNClob(String arg0, Reader arg1) throws SQLException
	{
	}

	public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
	}

	public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException
	{
	}

	public NClob getNClob(int arg0) throws SQLException
	{
		return null;
	}

	public NClob getNClob(String arg0) throws SQLException
	{
		return null;
	}

	public RowId getRowId(int arg0) throws SQLException
	{
		return null;
	}

	public RowId getRowId(String arg0) throws SQLException
	{
		return null;
	}

	public SQLXML getSQLXML(int arg0) throws SQLException
	{
		return null;
	}

	public SQLXML getSQLXML(String arg0) throws SQLException
	{
		return null;
	}

	public void updateNClob(int arg0, NClob arg1) throws SQLException
	{

	}

	public void updateNClob(String arg0, NClob arg1) throws SQLException
	{

	}

	public void updateRowId(int arg0, RowId arg1) throws SQLException
	{

	}

	public void updateRowId(String arg0, RowId arg1) throws SQLException
	{

	}

	public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException
	{

	}

	public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException
	{
	}
}
