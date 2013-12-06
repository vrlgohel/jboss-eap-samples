package com.kapx.jboss.javaee6.service;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.jboss.javaee6.dao.AbstractBaseDAO;
import com.kapx.jboss.javaee6.dao.StudentDAO;
import com.kapx.jboss.javaee6.dao.impl.StudentDAOImpl;
import com.kapx.jboss.javaee6.entity.Student;
import com.kapx.jboss.javaee6.service.impl.StudentServiceBean;

@RunWith(Arquillian.class)
public class StudentServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(StudentServiceTest.class.getName());

	@Deployment(name = "student-test")
	public static Archive<?> createTestArchive() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "student-test.war");
		war.addClass(StudentService.class);
		war.addClass(StudentServiceBean.class);

		war.addClass(Student.class);

		war.addClass(AbstractBaseDAO.class);
		war.addClass(StudentDAO.class);
		war.addClass(StudentDAOImpl.class);
		war.addClass(StudentDAO.class);
		war.addClass(StudentDAOImpl.class);

		war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		war.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
		war.addAsWebInfResource("test-mysql-ds.xml");
		return war;
	}

	@EJB
	private StudentService studentServiceEJB;

	@Test
	@InSequence(1)
	public void test_insert_student() throws Exception {
		Student entity = new Student();
		entity.setFirstName("Aditi");
		entity.setLastName("Singh");
		entity.setEmail("aditi@gmail.com");

		entity = studentServiceEJB.save(entity);
		assertNotNull(entity);
		assertNotNull(entity.getId());
		LOG.info("Create new Student with ID {}", entity.getId());
	}

}
