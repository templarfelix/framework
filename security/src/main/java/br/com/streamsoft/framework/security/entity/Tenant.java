package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Fernando on 29/03/2016.
 */
@Entity
@Table(name = "TENANT",
	   schema = "SECURITY")
@NamedQueries({ @NamedQuery(
		name = "TENANT.FIND_ALL",
		query = "SELECT u FROM Tenant u ") })
public class Tenant extends BaseEntityImpl<Long> implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false,
			updatable = false)
	private String name;

	@Column(nullable = false,
			updatable = false)
	private String schemaName;

	@Version
	private Long version;

	@Override
	public Long getId()
	{
		return id;
	}

	@Override
	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public String getSchemaName()
	{
		return schemaName;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSchemaName(String schemaName)
	{
		this.schemaName = schemaName;
	}

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

}