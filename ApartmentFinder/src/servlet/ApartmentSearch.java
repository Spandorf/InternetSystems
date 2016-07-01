package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Apartment;
import model.ApartmentQuery;
import model.User;

/**
 * Servlet implementation class ApartmentSearch
 */
public class ApartmentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentSearch() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parse request parameters
		Date moveInDate = null;
		try {
			java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(request.getParameter("move_in_date"));
			moveInDate = new Date(utilDate.getTime());
		} catch(Exception e) {
			// TODO: handle date parse exception
		}
		
		double priceRangeLow = 0;
		double priceRangeHigh = 0;
		String priceLow = request.getParameter("price_range_low");
		String priceHigh = request.getParameter("price_range_high");
		if(priceLow != null && !priceLow.isEmpty()){
			priceRangeLow = Double.parseDouble(priceLow);
		}
		if(priceHigh != null && !priceHigh.isEmpty()){
			priceRangeHigh = Double.parseDouble(priceHigh);
		}
		
		String location = request.getParameter("location");
		String apartmentType = request.getParameter("apartment_type");
		
		// query for apartments
		ApartmentQuery query = new ApartmentQuery(moveInDate, priceRangeLow, priceRangeHigh, location, apartmentType);
		ArrayList<Apartment> searchResults = ApartmentQuery.FindApartments(query);
		
		// put results in the session and forward to search results jsp page
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			session.setAttribute("searchResults", searchResults);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("ApartmentSearchResults.jsp");
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