package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;
import model.Apartment;

public class Cart {
	private int CartId;
	private int UserId;
	private ArrayList<Integer> CartItems;
	
	//constructor with list of items
	public Cart(int cartId, int userId, ArrayList<Integer> items) {
		super();
		CartId = cartId;
		UserId = userId;
		CartItems = items;
	}
	
	//base constructor
	public Cart(int cartId, int userId) {
		super();
		CartId = cartId;
		UserId = userId;
	}
	
	public int getId() {
		return CartId;
	}
	public void setId(int cartId) {
		this.CartId = cartId;
	}
	public int getUser() {
		return UserId;
	}
	public void setName(int userId) {
		this.UserId = userId;
	}
	public ArrayList<Integer> getItems() {
		return CartItems;
	}
	
	public void setItems(ArrayList<Integer> items) {
		this.CartItems = items;
	}
	
	//Pulls cart items for a specified cart
	public static ArrayList<CartItem> getCartItemsById(int cartId) {
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT * from CartItems WHERE CartItems.CartId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				int cartItemId = rs.getInt("Id");
				int apartment = rs.getInt("ApartmentId");
				int leaseTerm = rs.getInt("LeaseTerm");
				cartItems.add(new CartItem(cartItemId, leaseTerm, apartment));
			}
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cartItems;
	}
	
	//Method to populate the apartment property for a list of CartItems
	public static ArrayList<CartItem> getCartItemsApts(ArrayList<CartItem> items) {
		try {
			for(CartItem item: items){
				Apartment apartment = Apartment.getApartment(item.getAptId());
				item.setApartment(apartment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
	//Wrapper method to pull cart items for a cart and populate apartment data for those items
	public static ArrayList<CartItem> getCartItems(int cartId) {
		ArrayList<CartItem> cartItems = getCartItemsById(cartId);
		if(cartItems == null || cartItems.isEmpty()){
			return new ArrayList<CartItem>();
		}
		else{
			cartItems = getCartItemsApts(cartItems);
			return cartItems;			
		}		
	}
	
	//Returns a cart for a specified user
	public static Cart getUserCart(int userId) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT * from Carts WHERE Carts.UserId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				Cart cart = new Cart(rs.getInt("Id"), rs.getInt("UserId"));
				rs.close();
				preparedStatement.close();
				return cart;
			}
			rs.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Creates a cart for the user
	public static void addCart(int userId) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "insert into Carts (UserId) values (?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Adds a cart item to the db
	public static void addCartItem(int cartId, int leaseTerm, int apartmentId) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "insert into CartItems (CartId, Apartmentid, LeaseTerm) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setInt(2, apartmentId);
			preparedStatement.setInt(3, leaseTerm);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Removes a cart item from the db
	public static void removeCartItem(int cartItemId) {
		
		Connection conn = DBUtil.getConnection();
		try {
			String query = "delete from CartItems where Id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartItemId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
