package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TransactionInfo;
import model.User;
import model.Cart;

/**
 * Servlet implementation class ViewAndApply
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			int aptId = Integer.parseInt(request.getParameter("apartmentId"));
			int leaseTerm = Integer.parseInt(request.getParameter("leaseTerm"));
			int userId = user.getId();
			Cart cart = Cart.getUserCart(userId);
			//If the user doesnt have a cart yet add one in the db
			if(cart == null){
				Cart.addCart(userId);
				cart = Cart.getUserCart(userId);
			}
			Cart.addCartItem(cart.getId(), leaseTerm, aptId);
		}
		else{
			response.sendRedirect("Welcome.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
