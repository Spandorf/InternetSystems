package servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import util.DBUtil;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User(userName, password);
		
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		Connection conn = DBUtil.getConnection();
		try {
			if(User.doesUserExist(userName)){
				response.sendRedirect("Welcome.jsp");
			}
			else{
				String query = "insert into User (username, password) values (?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setString( 1, user.getUserName() );
				preparedStatement.setString( 2, user.getPassword() );
				preparedStatement.executeUpdate();
				preparedStatement.close();
				response.sendRedirect("Welcome.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
