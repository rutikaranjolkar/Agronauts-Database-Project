package edu.neu.agronauts.ui.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.neu.agronauts.ui.domain.Crop;
import edu.neu.agronauts.ui.domain.Farmer;
import edu.neu.agronauts.ui.domain.FarmerServiceRequest;
import edu.neu.agronauts.ui.domain.FarmerServiceRequestCrop;
import edu.neu.agronauts.ui.services.AgronautService;
import edu.neu.agronauts.ui.services.impl.AgronautServiceImpl;

/**
 * Servlet implementation class SaveFarmerRequestServlet
 */
public class SaveFarmerRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgronautService service = AgronautServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/farmer/submitRequest.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		double x1 = Double.parseDouble(request.getParameter("farmLocX1"));
		double x2 = Double.parseDouble(request.getParameter("farmLocX2"));
		double y1 = Double.parseDouble(request.getParameter("farmLocY1"));
		double y2 = Double.parseDouble(request.getParameter("farmLocY2"));
		double x3 = Double.parseDouble(request.getParameter("farmLocX3"));
		double y3 = Double.parseDouble(request.getParameter("farmLocY3"));
		double x4 = Double.parseDouble(request.getParameter("farmLocX4"));
		double y4 = Double.parseDouble(request.getParameter("farmLocY4"));
		String[] summerCrops = request.getParameterValues("Scrop");
		String[] winterCrops = request.getParameterValues("Wcrop");

		HttpSession session = request.getSession();
		Farmer user = (Farmer) session.getAttribute("user");
		FarmerServiceRequest serviceRequest = new FarmerServiceRequest();
		serviceRequest.setFarmer(user);
		serviceRequest.setArea(20.0);
		serviceRequest.setX1(x1);
		serviceRequest.setX2(x2);
		serviceRequest.setY1(y1);
		serviceRequest.setY2(y2);
		serviceRequest.setX3(x3);
		serviceRequest.setY3(y3);
		serviceRequest.setX4(x4);
		serviceRequest.setY4(y4);
		serviceRequest.setInsertedBy(user.getFirstName());
		serviceRequest.setModifiedBy(user.getFirstName());

		serviceRequest.setStatus("PENDING");
		Date requestDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String dateString = sdf.format(requestDate);
		serviceRequest.setRequestDate(dateString);
		serviceRequest.setInsertedDate(dateString);
		serviceRequest.setModifiedDate(dateString);

		service.saveOrUpdateObject(serviceRequest);

		for (String cropNameSummer : summerCrops) {
			Crop crop = (Crop) service.queryForOne("from Crop c where c.name = :name",
					Collections.singletonMap("name", (Object) cropNameSummer));
			if (crop != null) {
				FarmerServiceRequestCrop farmerServiceRequestCrop = new FarmerServiceRequestCrop();
				farmerServiceRequestCrop.setRequest(serviceRequest);
				farmerServiceRequestCrop.setCrop(crop);
				farmerServiceRequestCrop.setSeason("Summer");
				service.saveOrUpdateObject(farmerServiceRequestCrop);

			}
		}

		for (String cropNameWinter : winterCrops) {
			Crop crop1 = (Crop) service.queryForOne("from Crop c where c.name = :name",
					Collections.singletonMap("name", (Object) cropNameWinter));
			if (crop1 != null) {
				FarmerServiceRequestCrop farmerServiceRequestCrop = new FarmerServiceRequestCrop();
				farmerServiceRequestCrop.setRequest(serviceRequest);
				farmerServiceRequestCrop.setCrop(crop1);
				farmerServiceRequestCrop.setSeason("Winter");
				service.saveOrUpdateObject(farmerServiceRequestCrop);
			}
		}
		resp.sendRedirect("farmerRequestList.html");
	}
}
