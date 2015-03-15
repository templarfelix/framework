#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.test;

		import static org.junit.Assert.assertNotNull;
		import static org.junit.Assert.assertTrue;

		import java.util.Date;
		import java.util.logging.Logger;

		import javax.inject.Inject;

		import org.jboss.arquillian.container.test.api.Deployment;
		import org.jboss.arquillian.junit.Arquillian;
		import org.jboss.arquillian.junit.InSequence;
		import org.jboss.shrinkwrap.api.Archive;
		import org.jboss.shrinkwrap.api.ShrinkWrap;
		import org.jboss.shrinkwrap.api.asset.EmptyAsset;
		import org.jboss.shrinkwrap.api.spec.WebArchive;
		import org.junit.Test;
		import org.junit.runner.RunWith;

		import br.com.streamsoft.framework.base.dao.CrudDAO;
		import br.com.streamsoft.framework.base.dao.exception.DaoException;
		import br.com.streamsoft.framework.base.dao.impl.CrudDAOImpl;
		import br.com.streamsoft.framework.base.entity.BaseEntity;
		import br.com.streamsoft.framework.base.entity.impl.BaseEntityImpl;
		import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;
		import br.com.streamsoft.framework.base.facade.CrudFacade;
		import br.com.streamsoft.framework.base.facade.impl.CrudFacadeImpl;
		import br.com.streamsoft.framework.base.mail.Mail;
		import br.com.streamsoft.framework.base.mail.impl.MailImpl;
		import br.com.streamsoft.framework.base.paging.DataPage;
		import br.com.streamsoft.framework.base.paging.Page;
		import br.com.streamsoft.framework.base.resources.Resources;

		import ${package}.dao.UserDAO;
		import ${package}.dao.impl.UserDAOImpl;
		import ${package}.entity.User;
		import ${package}.facade.UserFacade;
		import ${package}.facade.impl.UserFacadeImpl;
		import ${package}.filter.UserFilterData;

/**
 * @author Fernando <fernando@mksdev.com>
 * @version 0.0.1-SNAPSHOT
 */
@RunWith(Arquillian.class)
public class UserTest
{

	// Inject UserFacade
	@Inject
	UserFacade facade;

	// Inject Logger
	@Inject
	Logger log;

	/**
	 * Create a test.war file for deploy in JBoss
	 *
	 * @return Archive<?>
	 */
	@Deployment
	public static Archive<?> createTestArchive()
	{
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(User.class)
				.addClasses(UserFacade.class)
				.addClasses(UserFacadeImpl.class)
				.addClasses(UserDAO.class)
				.addClasses(UserDAOImpl.class)
				.addClass(UserFilterData.class)

						// Framewrok Class
				.addClasses(CrudFacade.class)
				.addClasses(CrudFacadeImpl.class)
				.addClasses(CrudDAO.class)
				.addClasses(CrudDAOImpl.class)
				.addClasses(DataPage.class)
				.addClasses(Page.class)
				.addClasses(DaoException.class)
				.addClasses(LogBaseEntityImpl.class)
				.addClasses(BaseEntityImpl.class)
				.addClasses(BaseEntity.class)
				.addClasses(Mail.class)
				.addClasses(MailImpl.class)

				.addClasses(Resources.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
						// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Test
	@InSequence(1)
	public void testPersist() throws Exception
	{
		User entity = getEntity();

		facade.persist(entity);
		assertNotNull(entity.getId());
		log.info(entity.getName() + " was persisted with id " + entity.getId());
	}

	@Test
	@InSequence(2)
	public void testMerge() throws Exception
	{
		User entity = getEntity();
		entity = facade.findByEmail(entity.getEmail());

		facade.merge(entity);
		assertNotNull(entity.getId());
		log.info(entity.getName() + " was persisted with id " + entity.getId());
	}

	@Test
	@InSequence(3)
	public void testFindByEmailCriteria() throws Exception
	{
		User entity = getEntity();
		entity = facade.findByEmailCriteria(entity.getEmail());

		log.info(entity.toString());
		assertNotNull(entity.getId());
	}

	@Test
	@InSequence(6)
	public void testFindByNameCriteriaPage() throws Exception
	{
		Page page = new Page(0, 15);

		DataPage<User> users = facade.findByNameCriteria("", page);

		assertTrue(users.getData().size() != 0);
	}

	@Test
	@InSequence(5)
	public void testFindByEmail() throws Exception
	{
		User entity = getEntity();
		entity = facade.findByEmail(entity.getEmail());

		log.info(entity.toString());
		assertNotNull(entity.getId());
	}

	@Test
	@InSequence(6)
	public void testFindByFilterPage() throws Exception
	{
		Page page = new Page(0, 15);
		UserFilterData filter = new UserFilterData();
		filter.setName("");

		DataPage<User> users = facade.findByFilter(filter, page);

		assertTrue(users.getData().size() != 0);
	}

	@Test
	@InSequence(6)
	public void testRemove() throws Exception
	{
		User entity = getEntity();
		entity = facade.findByEmail(entity.getEmail());

		facade.remove(entity);

		assertNotNull(entity.getId());
		log.info(entity.getName() + " was deleted with id " + entity.getId());
	}

	/**
	 * Get Entity For Test
	 */
	private User getEntity()
	{
		User entity = new User();
		entity.setName("Teste Unitario");
		entity.setEmail("teste.unitario@mksdev.com");
		entity.setPassword("1234@567");
		entity.setBirthDay(new Date());
		entity.setLastLogin(new Date());

		return entity;
	}

}
