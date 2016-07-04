package model;

import model.Apartment;

public class CartItem {
	private int CartItemId;
	private Apartment Apartment;
	private int LeaseTerm;
	private int AptId;
	
	public CartItem(int cartItemId, int leaseTerm, Apartment apartment) {
		super();
		CartItemId = cartItemId;
		LeaseTerm = leaseTerm;
		Apartment = apartment;
	}
	
	public CartItem(int cartItemId, int leaseTerm, int aptId) {
		super();
		CartItemId = cartItemId;
		LeaseTerm = leaseTerm;
		AptId = aptId;
	}
	
	public int getId() {
		return CartItemId;
	}
	
	public void setId(int cartItemId) {
		CartItemId = cartItemId;
	}
	
	public int getLeaseTerm() {
		return LeaseTerm;
	}
	
	public void setLeaseTerm(int leaseTerm) {
		LeaseTerm = leaseTerm;
	}
	
	public int getAptId() {
		return AptId;
	}
	
	public void setAptId(int aptId) {
		AptId = aptId;
	}
	
	public Apartment getApt() {
		return Apartment;
	}
	
	public void setApt(Apartment apt) {
		Apartment = apt;
	}
	
}
