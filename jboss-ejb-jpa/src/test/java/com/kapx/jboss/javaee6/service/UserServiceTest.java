package com.kapx.jboss.javaee6.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

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

import com.kapx.jboss.javaee6.dao.AbstractBaseDAO;
import com.kapx.jboss.javaee6.dao.RoleDAO;
import com.kapx.jboss.javaee6.dao.UserDAO;
import com.kapx.jboss.javaee6.dao.impl.RoleDAOImpl;
import com.kapx.jboss.javaee6.dao.impl.UserDAOImpl;
import com.kapx.jboss.javaee6.entity.Role;
import com.kapx.jboss.javaee6.entity.User;
import com.kapx.jboss.javaee6.service.impl.UserServiceBean;

@RunWith(Arquillian.class)
public class UserServiceTest {
	@Deployment(name = "ejb-jpa-test")
	public static Archive<?> createTestArchive() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "ejb-jpa-test.war");
		war.addClass(UserService.class);
		war.addClass(UserServiceBean.class);

		war.addClass(Role.class);
		war.addClass(User.class);

		war.addClass(AbstractBaseDAO.class);
		war.addClass(RoleDAO.class);
		war.addClass(RoleDAOImpl.class);
		war.addClass(UserDAO.class);
		war.addClass(UserDAOImpl.class);

		war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		war.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
		war.addAsWebInfResource("test-mysql-ds.xml");
		war.addAsWebInfResource("import.sql");
		return war;
	}

	@EJB
	private UserService userServiceEJB;

	@Test
	@InSequence(1)
	public void test_findByRole() throws Exception {
		final String roleName = "ROLE_ADMIN";
		Role role = userServiceEJB.findByRole(roleName);
		assertNotNull(role);
		assertEquals(roleName, role.getRole());
	}

	@Test
	@InSequence(2)
	public void test_insert_user() throws Exception {
		final String roleName = "ROLE_ADMIN";
		Role role = userServiceEJB.findByRole(roleName);
		User user = new User();
		user.setFirstName("DE");
		user.setLastName("KAPX");
		user.setUsername("dekapx");
		user.setPassword("password");
		user.setEmail("dekapx@gmail.com");
		user.setInsertTime(new Date());
		user.setUpdateTime(new Date());
		user.setRole(role);

		User entity = userServiceEJB.save(user);
		assertNotNull(entity);
		assertNotNull(entity.getId());
	}
}
