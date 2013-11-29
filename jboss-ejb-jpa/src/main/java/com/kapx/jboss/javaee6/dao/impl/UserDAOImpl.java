package com.kapx.jboss.javaee6.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.jboss.javaee6.dao.AbstractBaseDAO;
import com.kapx.jboss.javaee6.dao.UserDAO;
import com.kapx.jboss.javaee6.entity.User;

public class UserDAOImpl extends AbstractBaseDAO<User, Long> implements UserDAO {

	private static final Logger LOG = LoggerFactory.getLogger(UserDAOImpl.class.getName());

	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User save(final User entity) {
		super.persist(entity);

		LOG.info("persist user object " + entity.getId());
		return entity;
	}

}
