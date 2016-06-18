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
	
	public static User getUserByName(String username) {
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
	
	public static Boolean doesUserExist(String username) {
		if(getUserByName(username) == null){
			return false;
		}
		else{
			return true;
		}
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
		
		
		/*Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
	
	public static Boolean validateUser(User aUser, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		String realPassword = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			if(!p.containsKey(aUser.userName)) {
				return false;
			}
			realPassword = p.getProperty(aUser.userName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(realPassword.equals(aUser.password))
			return true;
		else
			return false;
	}
	
	// removeUser
	
	
}
