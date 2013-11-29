package com.kapx.jboss.javaee6.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kapx.jboss.javaee6.dao.UserDAO;
import com.kapx.jboss.javaee6.entity.User;

@ApplicationScoped
public class UserDAOImpl implements UserDAO {

	@PersistenceContext(unitName = "mysql-persistence-unit")
	private EntityManager entityManager;

	@Override
	public User save(final User entity) {
		entityManager.persist(entity);
		return entity;
	}

}
