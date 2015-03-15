package br.com.streamsoft.framework.base.entity.impl;

import br.com.streamsoft.framework.base.entity.BaseEntity;

import java.io.Serializable;

/**
 *
 * */
@SuppressWarnings("serial")
public abstract class BaseEntityImpl<ID extends Serializable> implements
		BaseEntity<ID>
{

	@Override
	public boolean entityIsNew()
	{
		return getId() == null;
	}

}
