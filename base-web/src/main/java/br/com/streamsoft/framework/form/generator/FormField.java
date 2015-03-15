package br.com.streamsoft.framework.form.generator;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fernando on 16/12/2014.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FormField implements Serializable
{

	private String key;
	// FIXME TRANSFORMAR EM ENUM
	private String type;
	private String label;
	private String placeholder;
	private Boolean required;
	private Boolean disabled;
	private String description;

	// CRIAR EXEMPLO
	private String hideExpression;

	private ModelOptions modelOptions;

	// type textArea
	private Integer lines;

	// type radio
	@JsonProperty("options")
	private List<RadioOptions> options;

	// type number
	@JsonProperty("min")
	private Long min;

	@JsonProperty("max")
	private Long max;

	@JsonProperty("options")
	private List<SelectOtions> selectOtptions;

	//FIXME ESCREVER CUSTOM COMPONENTS

	//FIXME ESCREVER DEMAIS PROPRIEDADES

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

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public String getPlaceholder()
	{
		return placeholder;
	}

	public void setPlaceholder(String placeholder)
	{
		this.placeholder = placeholder;
	}

	public Boolean getRequired()
	{
		return required;
	}

	public void setRequired(Boolean required)
	{
		this.required = required;
	}

	public Boolean getDisabled()
	{
		return disabled;
	}

	public void setDisabled(Boolean disabled)
	{
		this.disabled = disabled;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getHideExpression()
	{
		return hideExpression;
	}

	public void setHideExpression(String hideExpression)
	{
		this.hideExpression = hideExpression;
	}

	public ModelOptions getModelOptions()
	{
		return modelOptions;
	}

	public void setModelOptions(ModelOptions modelOptions)
	{
		this.modelOptions = modelOptions;
	}

	public Integer getLines()
	{
		return lines;
	}

	public void setLines(Integer lines)
	{
		this.lines = lines;
	}

	public List<RadioOptions> getOptions()
	{
		return options;
	}

	public void setOptions(List<RadioOptions> options)
	{
		this.options = options;
	}

	public Long getMin()
	{
		return min;
	}

	public void setMin(Long min)
	{
		this.min = min;
	}

	public Long getMax()
	{
		return max;
	}

	public void setMax(Long max)
	{
		this.max = max;
	}

	public List<SelectOtions> getSelectOtptions()
	{
		return selectOtptions;
	}

	public void setSelectOtptions(List<SelectOtions> selectOtptions)
	{
		this.selectOtptions = selectOtptions;
	}
}