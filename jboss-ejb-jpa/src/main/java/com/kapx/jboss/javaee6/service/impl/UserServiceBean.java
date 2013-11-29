package com.kapx.jboss.javaee6.service.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.kapx.jboss.javaee6.dao.RoleDAO;
import com.kapx.jboss.javaee6.dao.UserDAO;
import com.kapx.jboss.javaee6.entity.Role;
import com.kapx.jboss.javaee6.entity.User;
import com.kapx.jboss.javaee6.service.UserServiceLocal;
import com.kapx.jboss.javaee6.service.UserServiceRemote;

@Stateless
@Local(UserServiceLocal.class)
@Remote(UserServiceRemote.class)
public class UserServiceBean implements UserServiceLocal, UserServiceRemote {

	@Inject
	private UserDAO userDAO;

	@Inject
	private RoleDAO roleDAO;

	@Override
	public User save(final User user) {
		return userDAO.save(user);
	}

	@Override
	public Role findByRole(final String role) {
		return roleDAO.findByRole(role);
	}

}
