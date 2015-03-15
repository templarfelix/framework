package br.com.streamsoft.framework.form.generator;

import java.io.Serializable;

/**
 * Created by Fernando on 16/12/2014.
 */
public class ModelOptions implements Serializable
{
	private Boolean getterSetter = true;
	private Boolean allowInvalid = false;

	public Boolean getGetterSetter()
	{
		return getterSetter;
	}

	public void setGetterSetter(Boolean getterSetter)
	{
		this.getterSetter = getterSetter;
	}

	public Boolean getAllowInvalid()
	{
		return allowInvalid;
	}

	public void setAllowInvalid(Boolean allowInvalid)
	{
		this.allowInvalid = allowInvalid;
	}
}