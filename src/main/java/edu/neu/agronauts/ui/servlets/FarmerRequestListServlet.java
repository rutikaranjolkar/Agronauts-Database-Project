package edu.neu.agronauts.ui.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.neu.agronauts.ui.domain.FarmerServiceRequest;
import edu.neu.agronauts.ui.domain.FarmerServiceRequestCrop;
import edu.neu.agronauts.ui.domain.Farmer;
import edu.neu.agronauts.ui.services.AgronautService;
import edu.neu.agronauts.ui.services.impl.AgronautServiceImpl;

public class FarmerRequestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgronautService service = AgronautServiceImpl.getInstance();

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Farmer user = (Farmer) session.getAttribute("user");
		long farmerId = user.getId();
		List<FarmerServiceRequest> requests = service.getRequestsForFarmer(farmerId);

		if (requests != null && !requests.isEmpty()) {
			for (FarmerServiceRequest request : requests) {
				List<FarmerServiceRequestCrop> requestCrops = service.query(
						"from FarmerServiceRequestCrop fc where fc.request.id = :id",
						Collections.singletonMap("id", (Object) request.getId()));
				request.setCrops(requestCrops);
			}
		}

		req.setAttribute("allRequests", requests);
		req.getRequestDispatcher("/WEB-INF/farmer/farmerRequestList.jsp").forward(req, resp);
	}
}
