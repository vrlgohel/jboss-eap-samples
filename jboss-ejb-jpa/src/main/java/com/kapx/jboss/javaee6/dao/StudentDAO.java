package com.kapx.jboss.javaee6.dao;

import com.kapx.jboss.javaee6.entity.Student;

public interface StudentDAO {
	Student save(final Student entity);

	void delete(final Student entity);
}
