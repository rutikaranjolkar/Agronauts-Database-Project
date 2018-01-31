package edu.neu.agronauts.ui.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.neu.agronauts.ui.domain.Farmer;
import edu.neu.agronauts.ui.services.AgronautService;
import edu.neu.agronauts.ui.services.impl.AgronautServiceImpl;

public class FarmerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgronautService service = AgronautServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/farmer/farmerRegister.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String zip = req.getParameter("zip");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String fieldDetails = req.getParameter("fieldDetails");
		String cardExpiryDate = req.getParameter("cardExpiryDate");
		String cardNumber = req.getParameter("cardNumber");
		String cvvCode = req.getParameter("cvvCode");
		String cardName = req.getParameter("cardName");
		
		
		Date requestDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String dateString = sdf.format(requestDate);
		Farmer user = new Farmer(username, password, firstName, lastName);
		user.setEmail(email);
		user.setAddress1(address);
		user.setCity(city);
		user.setZipCode(zip);
		user.setState(state);
		user.setCountry(country);
		user.setFieldDetails(fieldDetails);
		user.setInsertedBy(firstName);
		user.setInsertedDate(dateString);
		user.setModifiedBy(firstName);
		user.setModifiedDate(dateString);
		user.setCardExpiryDate(cardExpiryDate);
		user.setCardNumber(cardNumber);
		user.setCardName(cardName);
		user.setCvvCode(cvvCode);
		
		
		service.saveOrUpdateUser(user);
		resp.sendRedirect("login.html");
	}
}
