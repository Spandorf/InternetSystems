package model;

import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class User {
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public static User getUserByName(String username) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from User where username=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				User user = new User(resultSet.getString("username"), resultSet.getString("password"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static Boolean doesUserExist(String username) {
		if(getUserByName(username) == null){
			return false;
		}
		else{
			return true;
		}
		
	}
	/*public void registerUser(Users aUser, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}*/
	
	// validateUser
	// removeUser
	
	
}
