#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.dao.impl;

		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;

		import javax.ejb.Stateless;
		import javax.persistence.criteria.CriteriaBuilder;
		import javax.persistence.criteria.CriteriaQuery;
		import javax.persistence.criteria.Expression;
		import javax.persistence.criteria.Root;

		import br.com.streamsoft.framework.base.dao.impl.CrudDAOImpl;
		import br.com.streamsoft.framework.base.paging.DataPage;
		import br.com.streamsoft.framework.base.paging.Page;
		import br.com.streamsoft.framework.base.security.Log;
		import br.com.streamsoft.framework.base.security.Security;

		import ${package}.dao.UserDAO;
		import ${package}.entity.User;
		import ${package}.filter.UserFilterData;

@Stateless

//Annotations of Framework
@Security
@Log
public class UserDAOImpl extends CrudDAOImpl<Long, User> implements UserDAO
{

	private static final long serialVersionUID = 1L;

	@Override
	public List<User> findAll()
	{
		return super.findNamed("USER.FIND_ALL");
	}

	@Override
	public User findByEmail(String email)
	{
		// Find By Email

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);

		return super.findNamed("USER.FIND_BY_EMAIL", params);
	}

	@Override
	public User findByEmailCriteria(String email)
	{
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<User> criteria = getCriteriaQuery();

		Root<User> root = criteria.from(User.class);
		Expression<User> exp = root.get("email");

		criteria.select(root).where(cb.equal(exp, email));

		return super.find(criteria);
	}

	@Override
	public DataPage<User> findByNameCriteria(String name, Page page)
	{
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<User> criteria = getCriteriaQuery();
		CriteriaQuery<Number> countCriteria = getCountCriteriaQuery();

		Root<User> from = criteria.from(User.class);
		Expression<String> exp = from.get("name").as(String.class);

		criteria.select(from).where(cb.like(exp, "%" + name + "%"));
		countCriteria.select(cb.count(countCriteria.from(User.class)))
				.where(cb.like(exp, "%" + name + "%"));

		return super.findList(criteria, countCriteria, page);
	}

	@Override
	public List<User> findByFilter(UserFilterData filter)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%" + filter.getName() + "%");

		return super.findListNamed("USER.FIND_BY_NAME", params);
	}

	@Override
	public DataPage<User> findByFilter(UserFilterData filter, Page page)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%" + filter.getName() + "%");

		return super.findListNamed("USER.FIND_BY_NAME", "USER.COUNT_FIND_BY_NAME", page, params);
	}

}
