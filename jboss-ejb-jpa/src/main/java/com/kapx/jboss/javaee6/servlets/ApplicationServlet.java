package com.kapx.jboss.javaee6.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.jboss.javaee6.entity.Role;
import com.kapx.jboss.javaee6.entity.User;
import com.kapx.jboss.javaee6.service.UserServiceLocal;

@WebServlet(name = "ApplicationServlet", urlPatterns = { "/ApplicationServlet" })
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationServlet.class.getName());

	@EJB
	private UserServiceLocal userServiceEJB;

	public ApplicationServlet() {
		LOG.info("ApplicationServlet initialized...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		LOG.info("Calling UserServiceLocal for role ");

		Role role = null;
		User user = null;

		role = userServiceEJB.findByRole("ROLE_ADMIN");
		writer.write("Role Found: " + role.getRole());

		user = new User();
		user.setFirstName("DE");
		user.setLastName("KAPX");
		user.setUsername("dekapx");
		user.setPassword("password");
		user.setEmail("dekapx@gmail.com");
		user.setInsertTime(new Date());
		user.setUpdateTime(new Date());
		user.setRole(role);

		userServiceEJB.save(user);
		LOG.info("Save user with username {} ", user.getUsername());

		role = userServiceEJB.findByRole("ROLE_USER");
		writer.write("Role Found: " + role.getRole());

		user = new User();
		user.setFirstName("TEST");
		user.setLastName("USER");
		user.setUsername("testuser");
		user.setPassword("password");
		user.setEmail("test@gmail.com");
		user.setInsertTime(new Date());
		user.setUpdateTime(new Date());
		user.setRole(role);

		userServiceEJB.save(user);
		LOG.info("Save user with username {} ", user.getUsername());

		writer.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
