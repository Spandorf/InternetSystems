package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class ApartmentQuery {
	private Date MoveInDate;
	private double PriceRangeLow;
	private double PriceRangeHigh;
	private String Location;
	private String ApartmentType;
	
	public ApartmentQuery(Date moveInDate, double priceRangeLow, double priceRangeHigh, String location,
			String apartmentType) {
		super();
		MoveInDate = moveInDate;
		PriceRangeLow = priceRangeLow;
		PriceRangeHigh = priceRangeHigh;
		Location = location;
		ApartmentType = apartmentType;
	}
	
	public Date getMoveInDate() {
		return MoveInDate;
	}
	public void setMoveInDate(Date moveInDate) {
		MoveInDate = moveInDate;
	}
	public double getPriceRangeLow() {
		return PriceRangeLow;
	}
	public void setPriceRangeLow(double priceRangeLow) {
		PriceRangeLow = priceRangeLow;
	}
	public double getPriceRangeHigh() {
		return PriceRangeHigh;
	}
	public void setPriceRangeHigh(double priceRangeHigh) {
		PriceRangeHigh = priceRangeHigh;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getApartmentType() {
		return ApartmentType;
	}
	public void setApartmentType(String apartmentType) {
		ApartmentType = apartmentType;
	}
	
	
	public static ArrayList<Apartment> FindApartments(ApartmentQuery queryData) {
		ArrayList<Apartment> apartments = new ArrayList<Apartment>();
		Connection conn = DBUtil.getConnection();
		try {
			//String query = "select * from Apartments where PricePerMonth > ? and " + 
						   //"PricePerMonth < ? and " + 
						   //"AptType = ?";
			
			String query = "select * from Apartments";
			
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setDouble(1, queryData.PriceRangeLow);
			//preparedStatement.setDouble(2, queryData.PriceRangeHigh);
			//preparedStatement.setString(3, queryData.ApartmentType);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("Id");
				String landlord = rs.getString("Landlord");
				String aptNumber = rs.getString("AptNumber");
				String aptType = rs.getString("AptType");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String area = rs.getString("Area");
				String bathrooms = rs.getString("Bathrooms");
				double pricePerMonth = rs.getDouble("PricePerMonth");
				double applicationFee = rs.getDouble("ApplicationFee");
				double damageDeposit = rs.getDouble("DamageDeposit");
				String description = rs.getString("Description");
				int availability = rs.getInt("Availability");
				Date availabilityDate = rs.getDate("AvailableDate");
				int agentId = rs.getInt("AgentId");
				
				Apartment apartment = new Apartment(id, landlord, aptNumber, aptType, address, city, state, 
													area, bathrooms, pricePerMonth, applicationFee, damageDeposit,
													description,  availability, availabilityDate, agentId);
				
				apartments.add(apartment);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		// get amenities for each apartment
		try {
			for(Apartment apt : apartments) {
				ArrayList<Amenity> amenities = new ArrayList<Amenity>();
				
				String query = "select * from ApartmentAmenities " + 
						"join Amenities on ApartmentAmenities.AmenityId = Amenities.Id " +
						"where ApartmentAmenities.ApartmentId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				preparedStatement.setInt(1, apt.getId());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					String description = rs.getString("Description");
					
					Amenity amenity = new Amenity(id, name, description);
					amenities.add(amenity);
				}
				
				apt.setAmenities(amenities);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// get community features for each apartment
		try {
			for(Apartment apt : apartments) {
				ArrayList<CommunityFeature> commFeatures = new ArrayList<CommunityFeature>();
				
				String query = "select * from ApartmentCommunityFeatures " + 
							   "join CommunityFeatures on ApartmentCommunityFeatures.CommunityFeatureId = CommunityFeatures.Id " +
							   "where ApartmentCommunityFeatures.ApartmentId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				preparedStatement.setInt(1, apt.getId());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					String description = rs.getString("Description");
					
					CommunityFeature feature = new CommunityFeature(id, name, description);
					commFeatures.add(feature);
				}
				
				apt.setCommunityFeatures(commFeatures);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		// get reviews for each apartment
		try {
			for(Apartment apt : apartments) {
				ArrayList<Review> reviews = new ArrayList<Review>();
				
				String query = "select * from Reviews " + 
						"where Reviews.ApartmentId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				preparedStatement.setInt(1, apt.getId());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("Id");
					String reviewerName = rs.getString("ReviewerName");
					Date reviewDate = rs.getDate("ReviewDate");
					int rating = rs.getInt("Rating");
					String reviewData = rs.getString("Review");
					int apartmentId = rs.getInt("ApartmentId");
					
					Review review = new Review(id, reviewerName, reviewDate, rating, reviewData, apartmentId);
					reviews.add(review);
				}
				
				apt.setReviews(reviews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return apartments;
	}
}









