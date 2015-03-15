package br.com.streamsoft.framework.progress;

import com.progress.open4gl.ProResultSet;

/**
 * @author Fernando
 * @version 2.0
 */
public interface ProgressBean
{

	public Object getField(int fieldnum);

	public void setData(ProResultSet resultset) throws Exception;

	public String getFieldName(String field);
}