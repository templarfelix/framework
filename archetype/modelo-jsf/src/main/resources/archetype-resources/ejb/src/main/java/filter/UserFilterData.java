#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.filter;

public class UserFilterData
{

	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}