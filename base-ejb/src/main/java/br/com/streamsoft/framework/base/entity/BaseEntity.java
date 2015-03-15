package br.com.streamsoft.framework.base.entity;

import javax.persistence.Transient;
import java.io.Serializable;

public interface BaseEntity<ID> extends Serializable
{

	@Transient
	public abstract ID getId();

	public abstract void setId(ID id);

	public boolean entityIsNew();

}
