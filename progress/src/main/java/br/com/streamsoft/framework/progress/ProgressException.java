package br.com.streamsoft.framework.progress;

import br.com.streamsoft.framework.progress.entity.RowErrors;

import java.util.List;

/**
 * @author Fernando
 * @version 2.0
 */
public class ProgressException extends Exception
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<RowErrors> errorList;

	public ProgressException(List<RowErrors> errors)
	{
		this.setErrorList(errors);
	}

	/**
	 * @return the errorList
	 */
	public List<RowErrors> getErrorList()
	{
		return errorList;
	}

	/**
	 * @param errorList the errorList to set
	 */
	public void setErrorList(List<RowErrors> errorList)
	{
		this.errorList = errorList;
	}

}
