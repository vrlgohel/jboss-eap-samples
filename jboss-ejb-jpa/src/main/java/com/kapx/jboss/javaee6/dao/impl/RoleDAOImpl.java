package com.kapx.jboss.javaee6.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.kapx.jboss.javaee6.dao.RoleDAO;
import com.kapx.jboss.javaee6.entity.Role;

@ApplicationScoped
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext(unitName = "mysql-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Role findByRole(final String role) {
		TypedQuery<Role> query = (TypedQuery<Role>) entityManager.createQuery("select r from Role r where r.role = ?1", Role.class);
		query.setParameter(1, role);

		List<Role> users = query.getResultList();

		return users.iterator().next();
	}

}