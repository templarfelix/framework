package br.com.streamsoft.framework.base.test.impl;

import br.com.streamsoft.framework.base.dao.exception.DaoException;
import br.com.streamsoft.framework.base.entity.impl.BaseEntityImpl;
import br.com.streamsoft.framework.base.facade.CrudFacade;
import br.com.streamsoft.framework.base.test.CrudTest;
import com.querydsl.core.types.dsl.EntityPathBase;
import junit.framework.Assert;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author Fernando <fernando@mksdev.com>
 * @version 0.0.1-SNAPSHOT
 */
public abstract class CrudTestImpl<ID extends Serializable, T extends BaseEntityImpl<ID>, Q extends EntityPathBase<T>>
		implements CrudTest<ID, T, Q>
{

	// Inject Logger
	@Inject
	Logger log;

	T currentEntity;
	private CrudFacade<ID, T, Q> facade;

	/**
	 *
	 * */
	protected abstract T getEntity();

	/**
	 * Return facade
	 *
	 * @return CrudFacade<ID, T>
	 */
	public CrudFacade<ID, T, Q> getFacade()
	{
		return this.facade;
	}

	/**
	 *
	 * */
	public void setFacade(CrudFacade<ID, T, Q> facade)
	{
		this.facade = facade;
	}

	@Test
	@InSequence(1)
	public void testEntity()
	{
		currentEntity = getEntity();

		Assert.assertNotNull(currentEntity);
	}

	// Tests
	@Test
	@InSequence(2)
	public void save() throws DaoException
	{
		currentEntity = getEntity();
		currentEntity = facade.persist(currentEntity);

		Assert.assertNotNull(currentEntity.getId());

		log.info(currentEntity + " was persisted with id "
				+ currentEntity.getId());
	}

	/**
	 * Test remove Entity
	 */
	@Test
	@InSequence(3)
	public void remove() throws DaoException
	{
		currentEntity = getEntity();
		currentEntity = facade.findById(currentEntity.getId());

		facade.remove(currentEntity);

		Assert.assertNotNull(currentEntity.getId());

		log.info(currentEntity.getClass() + " was deleted with id "
				+ currentEntity.getId());
	}

}
