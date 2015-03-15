#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.dao;

		import java.util.List;

		import br.com.streamsoft.framework.base.dao.CrudDAO;
		import br.com.streamsoft.framework.base.paging.DataPage;
		import br.com.streamsoft.framework.base.paging.Page;

		import ${package}.entity.User;
		import ${package}.filter.UserFilterData;

public interface UserDAO extends CrudDAO<Long, User>
{

	// Custom Methods
	public List<User> findAll();

	public List<User> findByFilter(UserFilterData filter);

	public DataPage<User> findByFilter(UserFilterData filter, Page page);

	public User findByEmail(String email);

	public User findByEmailCriteria(String email);

	public DataPage<User> findByNameCriteria(String name, Page page);

}
