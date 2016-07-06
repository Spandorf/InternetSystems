package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Apartment;
import model.Cart;
import model.CartItem;
import model.TransactionInfo;
import model.User;

/**
 * Servlet implementation class ViewAndApply
 */
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apply() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
			cartItems = Cart.getCartItems(cartId);
			
			boolean available = true;
			double appTotal = 0;  
			//Check if each apartment is available
			for(CartItem cartItem : cartItems){
				Apartment apart = cartItem.getApartment();
				if(!cartItem.getApartment().isAvailable(cartItem.getLeaseTerm(), apart)){
					available = false;
					//Adds up the total for all applications
					appTotal += cartItem.getTotal();
				}
			}
			if(available){
				session.setAttribute("cartId", cartId);
				session.setAttribute("appTotal", appTotal);
				session.setAttribute("cartItems", cartItems);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmApplication.jsp");
			    dispatcher.forward(request, response);
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
		doGet(request, response);
	}

}
