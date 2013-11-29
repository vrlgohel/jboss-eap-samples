package com.kapx.jboss.javaee6.service;

import com.kapx.jboss.javaee6.entity.Role;
import com.kapx.jboss.javaee6.entity.User;

public interface UserServiceRemote {
	User save(User user);

	Role findByRole(String role);
}
