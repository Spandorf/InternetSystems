package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class CreditCard {
	private int Id;
	private String CardholderName;
	private String CreditCardNumber;
	private double Balance;
	private String CardType;
	private int UserId;
	private String CVV;
	private Date ExpirationDate;
	
	public CreditCard(int id, String cardholderName, String creditCardNumber, double balance, String cardType,
			int userId, String cVV, Date expirationDate) {
		super();
		Id = id;
		CardholderName = cardholderName;
		CreditCardNumber = creditCardNumber;
		Balance = balance;
		CardType = cardType;
		UserId = userId;
		CVV = cVV;
		ExpirationDate = expirationDate;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getCardholderName() {
		return CardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.CardholderName = cardholderName;
	}
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.CreditCardNumber = creditCardNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		this.Balance = balance;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		this.CardType = cardType;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		this.UserId = userId;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		this.CVV = cVV;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.ExpirationDate = expirationDate;
	}
	
	//Pulls the balance for a credit card
	public static double getBalance(int ccId) {
		double balance = 0;
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from CreditCards where CreditCards.Id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, ccId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			double dbBalance = rs.getDouble("Balance");
			balance = dbBalance;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}
	
	//Updates the balance for a cc
	public static void updateBalance(int ccId, double balance) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "update CreditCards set Balance=? where CreditCards.Id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setDouble(1, balance);
			preparedStatement.setInt(2, ccId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Pulls the ccId for a credit card number
	public static int getCreditCardIdByNumber(String creditCardNumber) {
		int id = 0;
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from CreditCards where CreditCards.CreditCardNumber LIKE ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "%" + creditCardNumber + "%");
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			id = rs.getInt("Id");

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	/*
	 * If validation is unsuccessful, returns an error message.
	 * If successful, returns null.
	 */
	public static String validateCC(CreditCard cc, double appCost) {
		String errorMessage = null;
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from CreditCards where CreditCards.Id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cc.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			String ccName = rs.getString("CardholderName");
			String ccNum = rs.getString("CreditCardNumber");
			String ccType = rs.getString("CardType");
			String ccCVV = rs.getString("CVV");
			String ccExp = rs.getString("ExpirationDate");
			double ccBalance = rs.getDouble("Balance");
			
			ccExp +="-11";
			if(!cc.getCardholderName().equals(ccName)){
				errorMessage = "Incorrect cardholder.";
			}
			else if(!cc.getCreditCardNumber().equals(ccNum)){
				errorMessage = "Incorrect card number.";
			}
			else if(!cc.getCardType().equals(ccType)){
				errorMessage = "Incorrect type.";
			}		
			else if(!cc.getCVV().equals(ccCVV)){
				errorMessage = "Incorrect ccv.";
			}	
			else if(ccBalance < appCost) {
				errorMessage = "Insufficient funds.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return errorMessage;
	}
}
