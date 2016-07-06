package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Apartment;
import model.Cart;
import model.CartItem;
import model.User;

/**
 * Servlet implementation class ViewApartment
 */
@WebServlet(name="/ViewCart",
urlPatterns={"/ViewCart"})
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			int userId = user.getId();
			Cart cart = Cart.getUserCart(userId);
			ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
			double appTotal = 0;
			if(cart == null){
				session.setAttribute("cartEmpty", 1);
			}
			else{
				cartItems = Cart.getCartItems(cart.getId());
				if(cartItems == null || cartItems.isEmpty()){
					session.setAttribute("cartEmpty", 1);
					session.setAttribute("total", appTotal);
				}
				else{
					session.setAttribute("cartEmpty", 0);
					for(CartItem cartItem : cartItems){
							//Adds up the total for all applications
							appTotal += cartItem.getTotal();
						}
					}
					session.setAttribute("total", appTotal);
			}
			session.setAttribute("cartId", cart.getId());
			session.setAttribute("cartItems", cartItems);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingCart.jsp");
		    dispatcher.forward(request, response);
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
