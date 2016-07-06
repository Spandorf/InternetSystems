package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		try {
			double appTotal = Double.parseDouble(request.getParameter("appTotal"));
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			String cardholder = request.getParameter("cardholder");
			String cardType = request.getParameter("cardType");
			String cardNumber = request.getParameter("cardNumber");
			String cvv = request.getParameter("cvv");
			
			model.Bank bank = new model.Bank(appTotal, cartId, cardholder, cardType, cardNumber, cvv);
			Status status = model.Bank.CheckBalance(bank);
			
			// trying to respond with json
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
					
			pw.print("{ \"transactionSuccess\": " + status.getSuccess().toString() + 
					 ", \"errorMessage\": \"" + status.getErrorMessage() + "\"}");
			
			pw.close();
		} catch (Exception e) {
			PrintWriter pw = response.getWriter();
			pw.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
