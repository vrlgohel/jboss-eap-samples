package com.kapx.jboss.javaee6.dao;

import com.kapx.jboss.javaee6.entity.User;

public interface UserDAO {
	User save(User entity);

	void delete(final User entity);
}
