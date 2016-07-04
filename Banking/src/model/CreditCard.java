package model;

import java.sql.Date;

public class CreditCard {
	private String CardholderName;
	private String CreditCardNumber;
	private String CardType;
	private String CVV;
	
	public CreditCard(String cardholderName, String creditCardNumber, String cardType, String cVV) {
		super();
		CardholderName = cardholderName;
		CreditCardNumber = creditCardNumber;
		CardType = cardType;
		CVV = cVV;
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
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
}
