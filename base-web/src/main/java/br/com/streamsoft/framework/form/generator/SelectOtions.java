package br.com.streamsoft.framework.form.generator;

import java.io.Serializable;

/**
 * Created by Fernando on 16/12/2014.
 */

// FIXME REMOVER SE NAO USADO
public class SelectOtions implements Serializable
{
	private String name;
	private String value;
	private String group;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getGroup()
	{
		return group;
	}

	public void setGroup(String group)
	{
		this.group = group;
	}
}