package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(schema = "SECURITY", name = "PASSWORD_RESET",
		uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
@NamedQueries({
		@NamedQuery(name = "PASSWORDRESET.FIND_ALL", query = "SELECT p FROM PasswordReset p ")
})
public class PasswordReset extends LogBaseEntityImpl<String> implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Size(min = 1, max = 512)
	@Column(name = "id")
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_user")
	private User user;

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public void setId(String id)
	{
		this.id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
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
		PasswordReset other = (PasswordReset) obj;
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
		StringBuilder str = new StringBuilder();
		str.append("\n   id=" + id);
		str.append("\n user=" + user.toString());
		return str.toString();
	}

}
