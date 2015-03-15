#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.controller;

		import java.io.Serializable;
		import java.util.List;

		import javax.annotation.PostConstruct;
		import javax.enterprise.context.SessionScoped;
		import javax.faces.application.FacesMessage;
		import javax.faces.context.FacesContext;
		import javax.inject.Inject;
		import javax.inject.Named;

		import br.com.streamsoft.framework.base.controller.HomeController;
		import br.com.streamsoft.framework.base.dao.exception.DaoException;
		import br.com.streamsoft.framework.base.security.Log;
		import br.com.streamsoft.framework.base.security.Security;
		import br.com.streamsoft.framework.base.security.ExceptionAware;
		import ${package}.datamodel.UserDataModel;
		import ${package}.entity.User;
		import ${package}.facade.UserFacade;
		import ${package}.filter.UserFilterData;

		import com.ocpsoft.pretty.faces.annotation.URLMapping;
		import com.ocpsoft.pretty.faces.annotation.URLMappings;

@SessionScoped
@Named
@URLMappings(mappings = {
		@URLMapping(id = "user_list", pattern = "/cadastros/usuario/",
				viewId = "/cadastros/usuario/usuarioList.jsf"),
		@URLMapping(id = "user_list2", pattern = "/cadastros/usuario",
				viewId = "/cadastros/usuario/usuarioList.jsf") })
@Security
@Log
@ExceptionAware
public class UserCRUDController implements Serializable
{
	private static final long serialVersionUID = 1L;

	private static final String FORM_VIEW = "usuarioForm.xhtml";
	private static final String LIST_VIEW = "usuarioList.xhtml";

	@Inject
	private HomeController homeController;

	@Inject
	private FacesContext facesContext;

	@Inject
	private UserFacade facade;

	private UserFilterData filter = new UserFilterData();

	private User activeItem;

	@Inject
	private UserDataModel dataModel;

	private Integer rowsPerPage = 15;

	public String newItem()
	{
		setActiveItem(new User());

		return FORM_VIEW;
	}

	public String editItem()
	{
		return FORM_VIEW;
	}

	public String cancelForm()
	{
		return LIST_VIEW + "?faces-redirect=true";
	}

	/**
	 * @throws DaoException
	 */
	public String persist() throws DaoException
	{

		facade.save(getActiveItem());

		facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Registered!",
				"Registration successful"));

		clear();
		doSearch();

		// refresh view
		return LIST_VIEW + "?faces-redirect=true";
	}

	/**
	 *
	 * */
	public String removeItem() throws DaoException
	{
		facade.remove(getActiveItem());

		clear();
		doSearch();

		// refresh view
		return LIST_VIEW + "?faces-redirect=true";
	}

	public User findById(Long id)
	{
		return facade.findById(id);
	}

	public List<User> findAll()
	{
		return facade.findAll();
	}

	/**
	 *
	 * */
	public String doSearch()
	{
		getDataModel().setFilter(filter);
		getDataModel().load(0, rowsPerPage, null, null);
		return null;
	}

	/**
	 * Executa ao criar a view
	 */
	@PostConstruct
	public void initView()
	{
		clear();
	}

	/**
	 *
	 * */
	public void clear()
	{
		setActiveItem(new User());
	}

	/**
	 * Sample send Mail
	 */
	public void sendMail() throws Exception
	{
		facade.sendMail(getActiveItem());
	}

	/* GETERS AND SETTERS */

	public UserFilterData getFilter()
	{
		return filter;
	}

	public void setFilter(UserFilterData filter)
	{
		this.filter = filter;
	}

	public User getActiveItem()
	{
		return activeItem;
	}

	public void setActiveItem(User activeItem)
	{
		this.activeItem = activeItem;
	}

	public UserDataModel getDataModel()
	{
		return dataModel;
	}

	public void setDataModel(UserDataModel dataModel)
	{
		this.dataModel = dataModel;
	}

	public Integer getRowsPerPage()
	{
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage)
	{
		this.rowsPerPage = rowsPerPage;
	}
}
