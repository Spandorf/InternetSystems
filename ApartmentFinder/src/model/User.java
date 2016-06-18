package model;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	
	public static void registerUser(User user) {
		
		Connection conn = DBUtil.getConnection();
		try {
			String query = "insert into Users (Username, Password) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Will return the User object if the user exists and password was correct, otherwise returns null
	public static User validateUser(User userToValidate) {
		if(doesUserExist(userToValidate.userName)) {
			User actualUser = getUserByName(userToValidate.userName);
			if(userToValidate.password.equals(actualUser.password)) {
				return actualUser;
			}
		}
		
		return null;
	}
	
	private static Boolean doesUserExist(String username) {
		if(getUserByName(username) == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	private static User getUserByName(String username) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Users where Username=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				User user = new User(resultSet.getString("Username"), resultSet.getString("Password"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
