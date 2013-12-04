package com.kapx.jboss.javaee6.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Abstract JPA based DAO class consisting of common data access operations.
 * 
 * @author KAPIL
 * 
 * @param <T>
 *            Type of persistence object.
 * @param <PK>
 *            Datatype of Serializable primary key
 */
public abstract class AbstractBaseDAO<T, PK extends Serializable> {

	@PersistenceContext(unitName = "mysql-persistence-unit")
	private EntityManager entityManager;

	private Class<T> persistentClass;

	protected AbstractBaseDAO(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public T find(PK pk, Class<T> t) {
		return entityManager.find(t, pk);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll() {
		return this.entityManager.createQuery("select obj from " + this.persistentClass.getName() + " obj").getResultList();
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll(int page, int pageSize) {
		TypedQuery<T> query = (TypedQuery<T>) entityManager.createQuery("select obj from " + this.persistentClass.getName() + " obj");

		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}
}
