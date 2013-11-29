package com.kapx.jboss.javaee6.dao;

import com.kapx.jboss.javaee6.entity.Role;

public interface RoleDAO {
	Role findByRole(String role);
}
