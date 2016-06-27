package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Application;
import model.User;

/**
 * Servlet implementation class ViewAndApply
 */
public class CancelApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelApp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appId = Integer.parseInt(request.getParameter("id"));
		Application app = Application.getApp(appId);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && !user.getUsername().isEmpty()){
			session.setAttribute("application", app);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("CancelApplication.jsp");
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
