package com.kapx.jboss.javaee6.service;

import java.util.Collection;

import com.kapx.jboss.javaee6.entity.Role;
import com.kapx.jboss.javaee6.entity.User;

public interface UserService {
	User save(User entity);

	Role save(Role entity);

	Role findByRole(String roleName);

	Collection<Role> findAllRoles();
}
