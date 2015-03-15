#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.rest;

		import java.util.List;

		import javax.enterprise.context.RequestScoped;
		import javax.inject.Inject;
		import javax.persistence.EntityManager;
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.PathParam;
		import javax.ws.rs.Produces;

		import ${package}.entity.User;

/**
 * @author Fernando <fernando@mksdev.com>
 * @version 0.0.1-SNAPSHOT
 */
@Path("/users")
@RequestScoped
public class UserResourceRESTService
{

	@Inject
	private EntityManager em;

	@GET
	@Produces("text/xml")
	public List<User> listAllUsers()
	{
		@SuppressWarnings("unchecked")
		final List<User> results = em.createQuery(
				"select u from User u order by u.name").getResultList();
		return results;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("text/xml")
	public User lookupUserByName(@PathParam("id") Long id)
	{
		return em.find(User.class, id);
	}
}
