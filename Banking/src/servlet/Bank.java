package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CreditCard;
import model.Status;

/**
 * Servlet implementation class Bank
 */
public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardholderName = request.getParameter("cardholderName");
		String ccNumber = request.getParameter("creditCardNumber");
		String cardType = request.getParameter("cardType");
		String cvv = request.getParameter("cvv");
		double cost = Double.parseDouble(request.getParameter("cost"));
		
		CreditCard cc = new CreditCard(cardholderName, ccNumber, cardType, cvv);
		model.Bank bankQuery = new model.Bank(cc, cost);
		Status status = model.Bank.CheckBalance(bankQuery);
		
		// trying to respond with json
		response.setContentType("application/json");
		response.getWriter().write("{ transactionSuccess: " + status.getSuccess().toString() + 
								   ", errorMessage: " + status.getErrorMessage() + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
