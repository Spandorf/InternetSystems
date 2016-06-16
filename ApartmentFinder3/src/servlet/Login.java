package servlet;


import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import util.DBUtil;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */
		
		/*
		 * Note: the content of the properties file may not be visible
		 */
		 
		/* Following two statements are used to obtain the absolute path 
		   of the users.properies file from its relative path. */

		
		Connection conn = DBUtil.getConnection();

		if(User.doesUserExist(userName)){
			User dbUser = User.getUserByName(userName);
			if(dbUser.getPassword().equals(password)){
				response.sendRedirect("CustomerHome.jsp"); // Link-redirection
			}
			else{
				response.sendRedirect("Register.jsp"); // Link-redirection
			}
		}
		else{
			response.sendRedirect("Register.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
