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
	
	public Cart(int cartId, int userId, ArrayList<Integer> items) {
		super();
		CartId = cartId;
		UserId = userId;
		CartItems = items;
	}
	
	public Cart(int cartId, int userId) {
		super();
		CartId = cartId;
		UserId = userId;
	}
	
	public int getId() {
		return CartId;
	}
	public void setId(int cartId) {
		CartId = cartId;
	}
	public int getUser() {
		return UserId;
	}
	public void setName(int userId) {
		UserId = userId;
	}
	public ArrayList<Integer> getItems() {
		return CartItems;
	}
	public void setItems(ArrayList<Integer> items) {
		CartItems = items;
	}
	
	public static ArrayList<Integer> getCartItems(int cartId) {
		ArrayList<Integer> cartItems = new ArrayList<Integer>();
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT * from CartItems WHERE CartItems.CartId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				int apartment = rs.getInt("ApartmentId");
				cartItems.add(apartment);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cartItems;
	}
	
	public static ArrayList<Apartment> getCartItems(ArrayList<Integer> items) {
		ArrayList<Apartment> apartments = new ArrayList<Apartment>();
		try {
			for(Integer item: items){
				Apartment apartment = Apartment.getApartment(item);
				apartments.add(apartment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return apartments;
	}
	
	public static Cart getUserCart(int userId) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT * from Cart WHERE Cart.UserId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				rs.close();
				preparedStatement.close();
				Cart cart = new Cart(rs.getInt("Id"), rs.getInt("UserId"));
				return cart;
			}
			rs.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void addCart(int userId) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "insert into Cart (UserId) values (?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCartItem(int cartId, int apartmentId) {
		Connection conn = DBUtil.getConnection();
		try {
			String query = "insert into CartItems (CartId, Apartmentid) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setInt(2, apartmentId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
