#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.datamodel;

		import java.util.ArrayList;
		import java.util.List;
		import java.util.Map;

		import javax.enterprise.context.SessionScoped;
		import javax.inject.Inject;
		import javax.inject.Named;

		import org.primefaces.model.LazyDataModel;
		import org.primefaces.model.SortMeta;
		import org.primefaces.model.SortOrder;

		import br.com.streamsoft.framework.base.paging.DataPage;
		import br.com.streamsoft.framework.base.paging.Page;

		import ${package}.entity.User;
		import ${package}.facade.UserFacade;
		import ${package}.filter.UserFilterData;

@SessionScoped
@Named
public class UserDataModel extends LazyDataModel<User>
{
	private static final long serialVersionUID = 1L;

	@Inject
	private UserFacade facade;

	/* 
	 * É necessário salvar o filtro no dataModel para que possa
	 * memorizar a busca do usuário na troca de página.
	 */
	private UserFilterData filter;

	/*
	 * O método principal do dataModel é o load, onde os dados são
	 * buscados no banco. Como os dados vêm do banco prontos, apenas
	 * os dois primeiros parâmetros são necessários.
	 */
	@Override
	public List<User> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters)
	{
		if (filter == null)
		{
			return new ArrayList<User>();
		}

		Page page = new Page(first, pageSize);

		DataPage<User> result = facade.findByFilter(filter, page);
		setPageSize(pageSize);
		setRowCount(result.getCount().intValue());
		setWrappedData(result.getData());

		return result.getData();
	}

	// Este método precisa ser sobrescrito, chamando o anterior.
	@Override
	public List<User> load(int first, int pageSize,
			List<SortMeta> multiSortMeta, Map<String, String> filters)
	{
		return load(first, pageSize, null, null, null);
	}

	/**
	 * Retorna o objeto selecionado a partir da chave.
	 */
	@Override
	public User getRowData(String rowKey)
	{
		return facade.findById(Long.valueOf(rowKey));
	}

	/**
	 * Retorna a chave do objeto informado.
	 */
	@Override
	public Object getRowKey(User user)
	{
		return user.getId();
	}

	public UserFilterData getFilter()
	{
		return filter;
	}

	public void setFilter(UserFilterData filter)
	{
		this.filter = filter;
	}
}
