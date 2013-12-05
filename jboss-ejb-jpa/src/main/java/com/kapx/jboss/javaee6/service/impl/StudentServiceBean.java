package com.kapx.jboss.javaee6.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.kapx.jboss.javaee6.entity.Student;
import com.kapx.jboss.javaee6.service.StudentService;

@Stateless
@Local(StudentService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StudentServiceBean implements StudentService {

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Student save(Student student) {
		return null;
	}

}
