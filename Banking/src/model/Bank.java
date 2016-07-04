package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class Bank {
	private CreditCard CardDetails;
	private double Cost;

	public Bank(CreditCard cardDetails, double cost) {
		super();
		CardDetails = cardDetails;
		Cost = cost;
	}

	public CreditCard getCardDetails() {
		return CardDetails;
	}
	
	public void setCardDetails(CreditCard cardDetails) {
		CardDetails = cardDetails;
	}
	
	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}

	public static Status CheckBalance(Bank bankCheck) {
		Status status = new Status(false, "");
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from CreditCards where CreditCards.CreditCardNumber = ?";
			PreparedStatement prepState = conn.prepareStatement(query);
			prepState.setString(1, bankCheck.CardDetails.getCreditCardNumber());
			ResultSet rs = prepState.executeQuery();
			
			if(rs.next()) {
				int ccId = rs.getInt("Id");
				String cardholderName = rs.getString("CardholderName");
				String cardType = rs.getString("CardType");
				String cvv = rs.getString("CVV");
				double balance = rs.getDouble("Balance");
				prepState.close();
				
				// make sure cc info is correct
				CreditCard ccDetails = bankCheck.getCardDetails();
				if(!ccDetails.getCardholderName().equals(cardholderName) ||
				   !ccDetails.getCardType().equals(cardType) ||
				   !ccDetails.getCVV().equals(cvv)) {
					status.setErrorMessage("Incorrect card details");
					return status;
				}
				
				// check balance of cc, update it if transaction can be completed
				double newBalance = balance - bankCheck.getCost();
				if(newBalance > 0) {
					status.setSuccess(true);
					query = "update CreditCards set Balance = ? where Id = ?";
					prepState = conn.prepareStatement(query);
					prepState.setDouble(1, newBalance);
					prepState.setInt(2, ccId);
					prepState.executeUpdate();
					return status;
				} else {
					status.setErrorMessage("Balance not high enough");
					return status;
				}
			} else {
				status.setErrorMessage("Card not found.");
				return status;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
