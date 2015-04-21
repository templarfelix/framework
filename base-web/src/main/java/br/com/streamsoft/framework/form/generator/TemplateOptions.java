package br.com.streamsoft.framework.form.generator;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 * Created by Fernando on 03/04/2015.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TemplateOptions
{
	// FIXME TRANSFORMAR EM ENUM
	private String type;
	private String label;
	private String placeholder;
	private Boolean required;

	// NUMBER
	private Long min;
	private Long max;
	private Long width;
	private String pattern;

	//FIXME VALIDAR NOMES
	private List<RadioOptions> options;
	private List<SelectOtions> selectOtptions;

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

	public Long getWidth()
	{
		return width;
	}

	public void setWidth(Long width)
	{
		this.width = width;
	}

	public String getPattern()
	{
		return pattern;
	}

	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}

	public List<RadioOptions> getOptions()
	{
		return options;
	}

	public void setOptions(List<RadioOptions> options)
	{
		this.options = options;
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
