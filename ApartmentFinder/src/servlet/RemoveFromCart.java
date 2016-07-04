package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TransactionInfo;
import model.User;
import model.Cart;
import model.CartItem;

/**
 * Servlet implementation class ViewAndApply
 */
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			Cart.removeCartItem(itemId);
			int userId = user.getId();
			Cart cart = Cart.getUserCart(userId);
			ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
			if(cart == null){
				session.setAttribute("cartEmpty", 1);
			}
			else{
				cartItems = Cart.getCartItems(cart.getId());
				if(cartItems == null || cartItems.isEmpty()){
					session.setAttribute("cartEmpty", 1);
				}
				else{
					session.setAttribute("cartEmpty", 0);
				}
			}
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
