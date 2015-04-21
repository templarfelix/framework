package br.com.streamsoft.framework.form.generator;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Fernando on 16/12/2014.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FormField implements Serializable
{

	private String key;
	// FIXME TRANSFORMAR EM ENUM
	private String type;

	private TemplateOptions templateOptions = new TemplateOptions();

	private Map<String, String> expressionProperties;

	private Map<String, String> validators;

	private Map<String, Object> validation;

	/*
	"optionsTypes": [
      "ipAddress"
    ],
    * optionsTypes
	* optionsTypes: ['checked'],
    */
	private List<Object> optionsTypes;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public TemplateOptions getTemplateOptions()
	{
		return templateOptions;
	}

	public void setTemplateOptions(TemplateOptions templateOptions)
	{
		this.templateOptions = templateOptions;
	}

	public Map<String, String> getExpressionProperties()
	{
		return expressionProperties;
	}

	public void setExpressionProperties(Map<String, String> expressionProperties)
	{
		this.expressionProperties = expressionProperties;
	}

	public Map<String, String> getValidators()
	{
		return validators;
	}

	public void setValidators(Map<String, String> validators)
	{
		this.validators = validators;
	}

	public Map<String, Object> getValidation()
	{
		return validation;
	}

	public void setValidation(Map<String, Object> validation)
	{
		this.validation = validation;
	}

	public List<Object> getOptionsTypes()
	{
		return optionsTypes;
	}

	public void setOptionsTypes(List<Object> optionsTypes)
	{
		this.optionsTypes = optionsTypes;
	}
}