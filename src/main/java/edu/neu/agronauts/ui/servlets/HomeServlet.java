package edu.neu.agronauts.ui.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.neu.agronauts.ui.domain.FarmerServiceRequest;
import edu.neu.agronauts.ui.services.AgronautService;
import edu.neu.agronauts.ui.services.impl.AgronautServiceImpl;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgronautService service = AgronautServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String role = (String) session.getAttribute("role");
		if (role.equals("admin")) {
			List<FarmerServiceRequest> serviceRequests = service.getPendingRequests();
			req.setAttribute("pendingRequests", serviceRequests);
			req.getRequestDispatcher("/WEB-INF/admin/home.jsp").forward(req, resp);
		} else if (role.equals("farmer")) {
			req.getRequestDispatcher("/WEB-INF/farmer/home.jsp").forward(req, resp);
		}
	}

}
