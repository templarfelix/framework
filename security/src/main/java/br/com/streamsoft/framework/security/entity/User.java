package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;
import br.com.streamsoft.framework.base.form.FieldType;
import br.com.streamsoft.framework.base.form.FormColumn;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "SECURITY", name = "USER",
		uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="published")
@DiscriminatorValue(value="true")

@NamedQueries({
		@NamedQuery(name = "USER.FIND_ALL", query = "SELECT u FROM User u "),
		@NamedQuery(name = "USER.FIND_BY_ID",
				query = "SELECT u FROM User u left join fetch u.listRoles left join fetch u.plan where u.id = :id "),
		@NamedQuery(name = "USER.FIND_BY_LOGIN",
				query = "SELECT u FROM User u WHERE TRIM(u.email) = trim(:login) "),
		@NamedQuery(name = "USER.LIKE_BY_NAME",
				query = "SELECT u FROM User u WHERE UPPER(u.name) like UPPER(:name) "),
		@NamedQuery(name = "USER.COUNT_LIKE_BY_NAME",
				query = "SELECT count(*) FROM User u WHERE UPPER(u.name) like UPPER(:name)") })
// WEBSERVICE
@XmlRootElement
public class User extends LogBaseEntityImpl<Long> implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* PK */

	// TODO TESTES DE FORMFIELD
	@FormColumn(description = "security_user", label = "security_user_label", placeholder = "security_user_placeholder")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@FormColumn(description = "security_email", label = "security_email_label", placeholder = "security_email_placeholder", filter = true, grid = true)
	@Email
	@NotNull
	@NotEmpty
	@Column(name = "email", unique = true)
	private String email;

	@FormColumn(description = "security_name", label = "security_name_label", placeholder = "security_name_placeholder")
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "name")
	private String name;

	/* 1 = actived, 0 = disabled */
	@FormColumn(description = "security_status", label = "security_status_label", placeholder = "security_name_placeholder")
	@NotNull
	@Column(name = "status", length = 1)
	private Long status;

	@FormColumn(type = FieldType.PASSSWORD ,description = "security_password", label = "security_password_label", placeholder = "security_password_placeholder")
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "password")
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_login")
	private Date lastLogin;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthDay;

	// Control version of Entity
	@Version
	private Long version;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "USER_ROLE", schema = "SECURITY", joinColumns = {
			@JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false,
					updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "id_role", referencedColumnName = "role", nullable = false,
					updatable = false) })
	private Set<Role> listRoles;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_plan")
	private Plan plan;

	/* GETTERS AND SETTERS */
	@Override
	public Long getId()
	{
		return this.id;
	}

	@Override
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Long getStatus()
	{
		return status;
	}

	public void setStatus(Long status)
	{
		this.status = status;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public Set<Role> getListRoles()
	{
		return listRoles;
	}

	public void addRole(Role role) {
		if(getListRoles() == null)
			setListRoles(new HashSet<Role>());
		listRoles.add(role);
	}

	public void setListRoles(Set<Role> listRoles)
	{
		this.listRoles = listRoles;
	}

	public Plan getPlan()
	{
		return plan;
	}

	public void setPlan(Plan plan)
	{
		this.plan = plan;
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		User other = (User) obj;
		if (id == null)
		{
			if (other.id != null)
			{
				return false;
			}
		}
		else if (!id.equals(other.id))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		str.append("\n        id=" + id);
		str.append("\n     email=" + email);
		str.append("\n      name=" + name);
		str.append("\n    status=" + status);
		str.append("\n  password=" + password);

		str.append("\n JOINS");

		return str.toString();
	}

}
