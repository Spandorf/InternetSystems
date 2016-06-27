package servlet;

import java.io.IOException;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CreditCard;
import model.TransactionInfo;
import model.User;
import model.Apartment;
import model.Application;

/**
 * Servlet implementation class CustomerTransactionConfirmation
 */
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double cost = Double.parseDouble(request.getParameter("cost"));
		String cardholderName = request.getParameter("cardholder");
		String creditCardNumber = request.getParameter("card_number");
		String cardType = request.getParameter("card_type");
		String cvv = request.getParameter("sec_code");
		int leaseTerm = Integer.parseInt(request.getParameter("leaseTerm"));
		Date expirationDate = null;
		try {
			java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(request.getParameter("exp_date"));
			expirationDate = new Date(utilDate.getTime());
		} catch(Exception e) {
			// TODO: handle date parse exception
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			
			int id = CreditCard.getCreditCardIdByNumber(creditCardNumber);
			CreditCard cc = new CreditCard(id, cardholderName, creditCardNumber, 0, cardType, user.getId(), cvv, expirationDate);

			Apartment apartment = Apartment.getApartment(Integer.parseInt(request.getParameter("aptId")));
			int numApps = Application.getNumApps(apartment.getId()) + 1;
			String appNum = apartment.getId() + "-" + numApps;
			
			String errorMessage = CreditCard.validateCC(cc, cost);
			
			if(errorMessage == null) { // means no error
				// TODO: associate application to user, reduce balance of cc
				Application application = new Application(0, apartment, 0, appNum, expirationDate, user.getId(), expirationDate, leaseTerm, cost, "", 1);
				Application.addApplication(application);
				Application completedApp = Application.getAppByAppNum(appNum);
				TransactionInfo transInfo = new TransactionInfo(apartment, completedApp);
				session.setAttribute("transaction", transInfo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionConfirmation.jsp");
				dispatcher.forward(request, response);
			} else {
				session.setAttribute("errorMessage", errorMessage);
			}
			
		}
		else{
			response.sendRedirect("Welcome.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
