package com.kapx.jboss.javaee6.dao.impl;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.jboss.javaee6.dao.AbstractBaseDAO;
import com.kapx.jboss.javaee6.dao.StudentDAO;
import com.kapx.jboss.javaee6.entity.Student;

@Named("studentDAO")
public class StudentDAOImpl extends AbstractBaseDAO<Student, Long> implements StudentDAO {

	private static final Logger LOG = LoggerFactory.getLogger(StudentDAOImpl.class.getName());

	public StudentDAOImpl() {
		super(Student.class);
	}

	@Override
	public Student save(final Student entity) {
		super.persist(entity);

		LOG.info("persist Student object with ID {} ", entity.getId());
		return entity;
	}

	public void delete(final Student entity) {
		LOG.info("Removing Student entity for ID {}", entity.getId());
		super.delete(entity);
	}

}
