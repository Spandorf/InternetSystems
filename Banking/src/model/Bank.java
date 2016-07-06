package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class Bank {
	private double AppTotal;
	private int CartId;
	private String Cardholder;
	private String CardType;
	private String CardNumber;
	private String Cvv;

	public Bank(double appTotal, int cartId, String cardholder, String cardType, String cardNumber, String cvv) {
		super();
		AppTotal = appTotal;
		CartId = cartId;
		Cardholder = cardholder;
		CardType = cardType;
		CardNumber = cardNumber;
		Cvv = cvv;
	}

	public double getAppTotal() {
		return AppTotal;
	}

	public void setAppTotal(double appTotal) {
		AppTotal = appTotal;
	}

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public String getCardholder() {
		return Cardholder;
	}

	public void setCardholder(String cardholder) {
		Cardholder = cardholder;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getCvv() {
		return Cvv;
	}

	public void setCvv(String cvv) {
		Cvv = cvv;
	}

	public static Status CheckBalance(Bank bank) {
		Status status = new Status(false, "");
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Carts " + 
						   "join CreditCards on Carts.UserId = CreditCards.Id " +
						   "where Carts.Id = ?";
			PreparedStatement prepState = conn.prepareStatement(query);
			prepState.setInt(1, bank.getCartId());
			ResultSet rs = prepState.executeQuery();
			
			if(rs.next()) {
				int ccId = rs.getInt("Id");
				String cardholderName = rs.getString("CardholderName");
				String cardType = rs.getString("CardType");
				String cardNumber = rs.getString("CreditCardNumber");
				String cvv = rs.getString("CVV");
				double balance = rs.getDouble("Balance");
				rs.close();
				prepState.close();
				
				// make sure cc info is correct
				if(!bank.getCardholder().equals(cardholderName) ||
				   !bank.getCardType().equals(cardType) ||
				   !bank.getCardNumber().equals(cardNumber) ||
				   !bank.getCvv().equals(cvv)) {
					status.setErrorMessage("Incorrect card details.");
					return status;
				}
				
				// check balance of cc, update it if transaction can be completed
				double newBalance = balance - bank.getAppTotal();
				if(newBalance > 0) {
					status.setSuccess(true);
					query = "update CreditCards set Balance = ? where Id = ?";
					prepState = conn.prepareStatement(query);
					prepState.setDouble(1, newBalance);
					prepState.setInt(2, ccId);
					prepState.executeUpdate();
					return status;
				} else {
					status.setErrorMessage("Balance not high enough.");
					return status;
				}
			} else {
				status.setErrorMessage("Card not found.");
				rs.close();
				prepState.close();
				return status;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
