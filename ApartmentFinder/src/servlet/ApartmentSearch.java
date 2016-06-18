package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Apartment;
import model.ApartmentList;
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
		Date moveInDate = null;
		double priceRangeLow = 0;
		double priceRangeHigh = 1000000000; // default really high in case they don't provide a high range
		String location = null;
		String apartmentType = null;
		
		try {
			java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse("move_in_date");
			moveInDate = new Date(utilDate.getTime());
			priceRangeLow = Double.parseDouble(request.getParameter("price_range_low"));
			priceRangeHigh = Double.parseDouble(request.getParameter("price_range_high"));
			location = request.getParameter("location");
			apartmentType = request.getParameter("apartment_type");
		} catch (Exception e) {
			// TODO: handle parse exception
		}
		
		ApartmentQuery query = new ApartmentQuery(moveInDate, priceRangeLow, priceRangeHigh, location, apartmentType);
		ApartmentList searchResults = ApartmentQuery.FindApartments(query);
		
		HttpSession session = request.getSession();
		session.setAttribute("searchResults", searchResults);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("ApartmentSearchResults.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}