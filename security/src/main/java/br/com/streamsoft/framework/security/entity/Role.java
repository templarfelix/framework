package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(schema = "SECURITY", name = "ROLE")
@NamedQueries({
		@NamedQuery(name = "ROLE.FIND_ALL", query = "SELECT r FROM Role r "),
		@NamedQuery(name = "ROLE.FIND_BY_ROLE",
				query = "SELECT r FROM Role r WHERE TRIM(r.role) = TRIM(:role) "),
		@NamedQuery(name = "ROLE.LIKE_BY_ROLE",
				query = "SELECT u FROM Role u WHERE UPPER(u.role) like UPPER(:role)"),
		@NamedQuery(name = "ROLE.COUNT_LIKE_BY_ROLE",
				query = "SELECT count(*) FROM Role u WHERE UPPER(u.role) like UPPER(:role)")
})
// webservice
@XmlRootElement
public class Role extends LogBaseEntityImpl<String> implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "role")
	private String role;

	@NotNull
	@Size(min = 1, max = 258)
	@Column(name = "description")
	private String description;

	public Role()
	{
	}

	public Role(String role)
	{
		this.role = role;
	}

	public Role(String role, String description)
	{
		this.role = role;
		this.description = description;
	}

	@Override
	@Transient
	public String getId()
	{
		return role;
	}

	@Override
	public void setId(String id)
	{
		this.role = id;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Role other = (Role) obj;
		if (role == null)
		{
			if (other.role != null)
			{
				return false;
			}
		}
		else if (!role.equals(other.role))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		str.append("\n        role=" + role);
		str.append("\n description=" + description);
		return str.toString();
	}

}
