package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class User {
	private int Id;
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private String PostalCode;
	private String EmailAddress;
	private String PhoneNumber;
	private String Birthday;
	private int Type;
	private int Status;
	private int NumbOfVisits;
	private String Username;
	private String Password;
	private ArrayList<Application> Applications;
	private ArrayList<CreditCard> CreditCards;
	
	public User(int id, String username, String password) {
		super();
		Username = username;
		Password = password;
		Id = id;
	}
	
	public User(int id, String firstName, String lastName, String address, String city, String state, String postalCode,
			String emailAddress, String phoneNumber, String birthday, int type, int status, int numbOfVisits,
			String username, String password, ArrayList<Application> applications, ArrayList<CreditCard> creditCards) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		City = city;
		State = state;
		PostalCode = postalCode;
		EmailAddress = emailAddress;
		PhoneNumber = phoneNumber;
		Birthday = birthday;
		Type = type;
		Status = status;
		NumbOfVisits = numbOfVisits;
		Username = username;
		Password = password;
		Applications = applications;
		CreditCards = creditCards;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		this.State = state;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		this.PostalCode = postalCode;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		this.Birthday = birthday;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		this.Type = type;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		this.Status = status;
	}
	public int getNumbOfVisits() {
		return NumbOfVisits;
	}
	public void setNumbOfVisits(int numbOfVisits) {
		this.NumbOfVisits = numbOfVisits;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public ArrayList<Application> getApplications() {
		return Applications;
	}
	public void setApplications(ArrayList<Application> applications) {
		this.Applications = applications;
	}
	public ArrayList<CreditCard> getCreditCards() {
		return CreditCards;
	}
	public void setCreditCards(ArrayList<CreditCard> creditCards) {
		this.CreditCards = creditCards;
	}
	
	//Adds a user to the db
	public static void registerUser(User user) {
		
		Connection conn = DBUtil.getConnection();
		try {
			String query = "insert into Users (Username, Password) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Will return the User object if the user exists and password was correct, otherwise returns null
	public static User validateUser(User userToValidate) {
		if(doesUserExist(userToValidate.Username)) {
			User actualUser = getUserByName(userToValidate.Username);
			if(userToValidate.Password.equals(actualUser.Password)) {
				return actualUser;
			}
		}
		
		return null;
	}
	
	//Checks if user exists in db
	private static Boolean doesUserExist(String username) {
		if(getUserByName(username) == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	//Pulls user by username
	private static User getUserByName(String username) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Users where Username=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				User user = new User(resultSet.getInt("Id"), resultSet.getString("Username"), resultSet.getString("Password"));
				resultSet.close();
				preparedStatement.close();
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
