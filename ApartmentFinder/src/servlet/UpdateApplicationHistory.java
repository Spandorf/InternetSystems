package servlet;

import java.io.IOException;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import model.Cart;
import model.CartItem;

/**
 * Servlet implementation class CustomerTransactionConfirmation
 */
public class UpdateApplicationHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateApplicationHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			java.sql.Date appDate = new java.sql.Date(new java.util.Date().getDate());
			ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
			cartItems = Cart.getCartItems(cartId);
			for(CartItem cartItem : cartItems){
				Apartment apt = cartItem.getApartment();
				int numApps = Application.getNumApps(apt.getId()) + 1;
				String appNum = apt.getId() + "-" + numApps;
				Application application = new Application(0, apt, 0, appNum, appDate, user.getId(), appDate, cartItem.getLeaseTerm(), cartItem.getTotal(), "", 1);
				Application.addApplication(application);
				Cart.removeCartItem(cartItem.getCartItemId());
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
