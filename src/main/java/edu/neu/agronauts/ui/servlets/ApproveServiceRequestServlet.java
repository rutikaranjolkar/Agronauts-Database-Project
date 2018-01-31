package edu.neu.agronauts.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.neu.agronauts.ui.domain.FarmerServiceRequest;
import edu.neu.agronauts.ui.services.AgronautService;
import edu.neu.agronauts.ui.services.impl.AgronautServiceImpl;

public class ApproveServiceRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgronautService service = AgronautServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String decision = request.getParameter("decision");
		String serviceRequestId = request.getParameter("id");
		FarmerServiceRequest serviceRequest = service.getRequestById(Long.parseLong(serviceRequestId));
		if (decision.equalsIgnoreCase("approve")) {
			serviceRequest.setStatus("Approved");
		} else {
			serviceRequest.setStatus("Rejected");
		}
		service.saveOrUpdateRequest(serviceRequest);
		resp.sendRedirect("home.html");
	}
}
