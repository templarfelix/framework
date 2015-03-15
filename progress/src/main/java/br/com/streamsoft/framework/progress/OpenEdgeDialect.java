package br.com.streamsoft.framework.progress;

import org.hibernate.dialect.ProgressDialect;

import java.sql.Types;

/**
 * @author Fernando
 * @version 2.0
 */
public class OpenEdgeDialect extends ProgressDialect
{

	public OpenEdgeDialect()
	{
		super();
		registerColumnType(Types.CLOB, "CLOB");
		registerColumnType(Types.BLOB, "BLOB");
	}

	public char openQuote()
	{
		return '"';
	}

	public char closeQuote()
	{
		return '"';
	}

}