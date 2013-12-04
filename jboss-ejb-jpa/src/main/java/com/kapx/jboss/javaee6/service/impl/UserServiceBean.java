package com.kapx.jboss.javaee6.service.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserServiceBean implements UserServiceLocal, UserServiceRemote {

	@Inject
	private UserDAO userDAO;

	@Inject
	private RoleDAO roleDAO;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User save(final User user) {
		return userDAO.save(user);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Role findByRole(final String role) {
		return roleDAO.findByRole(role);
	}

}
