#set($symbol_pound='#')
		#set($symbol_dollar='$')
		#set($symbol_escape='\' )
		package ${package}.entity;

		import java.io.Serializable;
		import java.util.Date;

		import javax.persistence.Column;
		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		import javax.persistence.Id;
		import javax.persistence.NamedQueries;
		import javax.persistence.NamedQuery;
		import javax.persistence.Table;
		import javax.persistence.Temporal;
		import javax.persistence.TemporalType;
		import javax.persistence.UniqueConstraint;
		import javax.persistence.Version;
		import javax.validation.constraints.NotNull;
		import javax.validation.constraints.Pattern;
		import javax.validation.constraints.Size;
		import javax.xml.bind.annotation.XmlRootElement;

		import org.hibernate.annotations.NamedNativeQuery;
		import org.hibernate.validator.constraints.Email;
		import org.hibernate.validator.constraints.NotEmpty;

		import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;

@Entity
// rest mapping
@XmlRootElement
@Table(schema = "SAMPLE", name = "SAMPLE_USER",
		uniqueConstraints = @UniqueConstraint(columnNames = "email"))

@NamedQueries({ @NamedQuery(name = "USER.FIND_ALL", query = "SELECT b FROM User b"),
		@NamedQuery(name = "USER.FIND_BY_EMAIL", query = "SELECT b FROM User b WHERE b.email = :email"),
		@NamedQuery(name = "USER.FIND_BY_NAME",
				query = "SELECT u FROM User u WHERE UPPER(u.name) like UPPER(:name)"),
		@NamedQuery(name = "USER.COUNT_FIND_BY_NAME",
				query = "SELECT count(*) FROM User u WHERE UPPER(u.name) like UPPER(:name)")
})

@NamedNativeQuery(name = "USER.FIND_BY_NATIVE_QUERY", query = "SELECT * FROM SAMPLE_USER",
		resultClass = User.class)
/**
 *
 *
 * */
public class User extends LogBaseEntityImpl<Long> implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	//sample use Sequence Generator
	//@SequenceGenerator(name = "demo_user_sequence", sequenceName = "demo_user_sequence", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_user_sequence")

	// sample use Identity Field
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	@NotNull
	@NotEmpty
	@Column(name = "email")
	private String email;
	@Size(min = 1, max = 256)
	@Column(name = "password")
	private String password;
	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "name")
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	private Date lastLogin;
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthDay;
	//Control version of Entity
	@Version
	private Long version;

	public User()
	{
	}

	public User(Long id, String email)
	{
		this.id = id;
		this.email = email;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	public Date getBirthDay()
	{
		return birthDay;
	}

	public void setBirthDay(Date birthDay)
	{
		this.birthDay = birthDay;
	}

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("\n id=" + id);
		str.append("\n email=" + email);
		str.append("\n name=" + name);
		str.append("\n password=" + password);
		str.append("\n lastLogin=" + lastLogin);
		str.append("\n birthDay=" + birthDay);
		str.append("\n version=" + version);
		return str.toString();
	}

}
