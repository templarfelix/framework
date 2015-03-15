#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.facade;

		import java.util.List;

		import br.com.streamsoft.framework.base.facade.CrudFacade;
		import br.com.streamsoft.framework.base.paging.DataPage;
		import br.com.streamsoft.framework.base.paging.Page;

		import ${package}.entity.User;
		import ${package}.filter.UserFilterData;

/**
 *
 * */
public interface UserFacade extends CrudFacade<Long, User>
{

	//Custom Methods
	public List<User> findAll();

	public List<User> findByFilter(UserFilterData filter);

	public DataPage<User> findByFilter(UserFilterData filter, Page page);

	public User findByEmail(String email);

	public User findByEmailCriteria(String email);

	public void sendMail(User user) throws Exception;

	public DataPage<User> findByNameCriteria(String name, Page page);
}
