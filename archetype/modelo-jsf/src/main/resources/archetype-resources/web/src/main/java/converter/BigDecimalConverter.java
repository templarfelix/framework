#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.converter;

		import java.math.BigDecimal;

		import javax.enterprise.context.RequestScoped;
		import javax.faces.component.UIComponent;
		import javax.faces.context.FacesContext;
		import javax.faces.convert.Converter;
		import javax.inject.Named;

@RequestScoped
@Named
public class BigDecimalConverter implements Converter
{

	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		return new BigDecimal(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		return ((BigDecimal) value).toPlainString();
	}
}