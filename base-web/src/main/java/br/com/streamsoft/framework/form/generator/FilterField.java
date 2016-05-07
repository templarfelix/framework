package br.com.streamsoft.framework.form.generator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by Fernando on 16/12/2014.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FilterField implements Serializable
{

	private String key;
	private String placeholder;
	private String name;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getPlaceholder()
	{
		return placeholder;
	}

	public void setPlaceholder(String placeholder)
	{
		this.placeholder = placeholder;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}