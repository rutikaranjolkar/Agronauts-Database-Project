package edu.neu.agronauts.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.neu.agronauts.ui.domain.Farmer;
import edu.neu.agronauts.ui.services.AgronautService;
import edu.neu.agronauts.ui.services.impl.AgronautServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgronautService agronautService = AgronautServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Farmer user = agronautService.authenticate(username, password);
		if ("admin".equalsIgnoreCase(username)) {
			HttpSession session = req.getSession();
			session.setAttribute("role", "admin");
			resp.sendRedirect("home.html");
		} else if (user == null) {
			req.setAttribute("error", "Incorrect credentials. Please try again");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("role", "farmer");
			resp.sendRedirect("home.html");
		}
	}
}
