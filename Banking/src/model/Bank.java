package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class Bank {
	private int CardId;
	private double Cost;
	
	public Bank(int cardId, double cost) {
		super();
		CardId = cardId;
		Cost = cost;
	}
	
	public int getCardId() {
		return CardId;
	}
	public void setCardId(int cardId) {
		CardId = cardId;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}

	public static Boolean CheckBalance(Bank bankCheck) {
		Boolean isValid = false; // flag for if the user has enough money for the transaction
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from CreditCards where CreditCards.Id = ?";
			PreparedStatement prepState = conn.prepareStatement(query);
			prepState.setInt(1, bankCheck.CardId);
			ResultSet rs = prepState.executeQuery();
			
			rs.next();
			double balance = rs.getDouble("Balance");
			prepState.close();
			
			double newBalance = balance - bankCheck.getCost();
			if(newBalance > 0) {
				isValid = true;
				query = "update CreditCards set Balance = ? where Id = ?";
				prepState = conn.prepareStatement(query);
				prepState.setDouble(1, newBalance);
				prepState.setInt(2, bankCheck.getCardId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isValid;
	}
}
