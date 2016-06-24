package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
		Id = id;
	}
	public String getCardholderName() {
		return CardholderName;
	}
	public void setCardholderName(String cardholderName) {
		CardholderName = cardholderName;
	}
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		ExpirationDate = expirationDate;
	}
	
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
	
	public static boolean validateCC(CreditCard cc) {
		boolean isValid = false;
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
			Date ccExp = rs.getDate("ExpirationDate");
			if(cc.getCardholderName().equals(ccName) &&
					cc.getCreditCardNumber().equals(ccNum) && 
					cc.getCardType().equals(ccType) &&
					cc.getCVV().equals(ccCVV) &&
					cc.getExpirationDate().equals(ccExp))
			{
				isValid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isValid;
	}
}
