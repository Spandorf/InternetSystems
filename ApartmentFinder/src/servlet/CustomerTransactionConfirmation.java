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
import model.User;

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
		Date expirationDate = null;
		try {
			java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(request.getParameter("exp_date"));
			expirationDate = new Date(utilDate.getTime());
		} catch(Exception e) {
			// TODO: handle date parse exception
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		int id = CreditCard.getCreditCardIdByNumber(creditCardNumber);
		
		CreditCard cc = new CreditCard(id, cardholderName, creditCardNumber, 0, cardType, user.getId(), cvv, expirationDate);
	
		String errorMessage = CreditCard.validateCC(cc, cost);
		
		if(errorMessage == null) { // means no error
			// TODO: associate application to user, reduce balance of cc
		} else {
			session.setAttribute("errorMessage", errorMessage);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionConfirmation.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
