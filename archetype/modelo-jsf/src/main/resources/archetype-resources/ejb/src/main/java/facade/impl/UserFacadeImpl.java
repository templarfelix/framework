#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.facade.impl;

		import java.util.List;

		import javax.inject.Inject;
		import javax.inject.Named;

		import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
		import br.com.streamsoft.framework.base.mail.Mail;
		import br.com.streamsoft.framework.base.paging.DataPage;
		import br.com.streamsoft.framework.base.paging.Page;
		import br.com.streamsoft.framework.base.security.Log;
		import br.com.streamsoft.framework.base.security.Security;

		import ${package}.dao.UserDAO;
		import ${package}.entity.User;
		import ${package}.facade.UserFacade;
		import ${package}.filter.UserFilterData;

@Named

//Annotations of Framework
@Security
@Log
public class UserFacadeImpl extends CrudFacadeImpl<Long, User> implements
		UserFacade
{

	private static final long serialVersionUID = 1L;
	@Inject
	private Mail mail;

	//Constructor with inject DAO
	@Inject
	public UserFacadeImpl(UserDAO dao)
	{
		super(dao);
	}

	@Override
	public List<User> findAll()
	{
		return ((UserDAO) super.getDAO()).findAll();
	}

	@Override
	public List<User> findByFilter(UserFilterData filter)
	{
		return ((UserDAO) super.getDAO()).findByFilter(filter);
	}

	@Override
	public DataPage<User> findByFilter(UserFilterData filter, Page page)
	{
		return ((UserDAO) super.getDAO()).findByFilter(filter, page);
	}

	@Override
	public DataPage<User> findByNameCriteria(String name, Page page)
	{
		return ((UserDAO) super.getDAO()).findByNameCriteria(name, page);
	}

	@Override
	public User findByEmail(String email)
	{
		return ((UserDAO) super.getDAO()).findByEmail(email);
	}

	@Override
	public User findByEmailCriteria(String email)
	{
		return ((UserDAO) super.getDAO()).findByEmailCriteria(email);
	}

	@Override
	public void sendMail(User user) throws Exception
	{
		mail.sendEmailText("sistemas@mksdev.com", user.getEmail(),
				"** Account Information **", "Your Name is: " + user.getName());
	}

}
