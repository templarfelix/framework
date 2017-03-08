package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.LogBaseEntityImpl;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(schema = "SECURITY", name = "PLAN")
@NamedQueries({
		@NamedQuery(name = "PLAN.FIND_ALL", query = "SELECT s FROM Plan s "),
		@NamedQuery(name = "PLAN.LIKE_BY_NAME",
				query = "SELECT s FROM Plan s WHERE UPPER(s.name) like UPPER(:name)"),
		@NamedQuery(name = "PLAN.COUNT_LIKE_BY_NAME",
				query = "SELECT count(*) FROM Plan S WHERE UPPER(S.name) like UPPER(:name)") })
// webservice
@XmlRootElement
public class Plan extends LogBaseEntityImpl<UUID> implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* PK */
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	//@Type(type="pg-uuid")
	private UUID id;

	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "name")
	private String name;

	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "days_for_expire")
	private Long daysForExpire;

	@NotNull
	@Column(name = "value")
	private BigDecimal value;

	@Override
	@Transient
	public UUID getId()
	{
		return id;
	}

	@Override
	public void setId(UUID id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Long getDaysForExpire()
	{
		return daysForExpire;
	}

	public void setDaysForExpire(Long daysForExpire)
	{
		this.daysForExpire = daysForExpire;
	}

	public BigDecimal getValue()
	{
		return value;
	}

	public void setValue(BigDecimal value)
	{
		this.value = value;
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
		Plan other = (Plan) obj;
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
		str.append("\n            id=" + id);
		str.append("\n          name=" + name);
		str.append("\n   description=" + description);
		str.append("\n daysForExpire=" + daysForExpire);
		str.append("\n         value=" + value);

		return str.toString();
	}

}
