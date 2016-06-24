package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TransactionInfo;

/**
 * Servlet implementation class ViewAndApply
 */
public class ViewAndApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndApply() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int aptId = Integer.parseInt(request.getParameter("id"));
		int leaseTerm = Integer.parseInt(request.getParameter("leaseTerm"));
		
		TransactionInfo transaction = TransactionInfo.getTransactionInfo(aptId, leaseTerm);
		
		HttpSession session = request.getSession();
		session.setAttribute("transaction", transaction);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerTransaction.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
