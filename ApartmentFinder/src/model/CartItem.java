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
	
	public int getCartItemId() {
		return CartItemId;
	}
	
	public void setCartItemId(int cartItemId) {
		this.CartItemId = cartItemId;
	}
	
	public int getLeaseTerm() {
		return LeaseTerm;
	}
	
	public void setLeaseTerm(int leaseTerm) {
		this.LeaseTerm = leaseTerm;
	}
	
	public int getAptId() {
		return AptId;
	}
	
	public void setAptId(int aptId) {
		this.AptId = aptId;
	}
	
	public Apartment getApartment() {
		return Apartment;
	}
	
	public void setApartment(Apartment apartment) {
		this.Apartment = apartment;
	}
	
}
