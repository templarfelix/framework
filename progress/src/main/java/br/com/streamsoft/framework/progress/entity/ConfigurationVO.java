package br.com.streamsoft.framework.progress.entity;

import java.io.Serializable;

/**
 * @author Fernando
 * @version 1.0
 */
public class ConfigurationVO implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	private String value;

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

}
