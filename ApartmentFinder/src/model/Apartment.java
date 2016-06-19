package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class Apartment {
	private int Id;
	private String Landlord;
	private String AptNumber;
	private String AptType;
	private String Address;
	private String City;
	private String State;
	private String Area;
	private String Bathrooms;
	private double PricePerMonth;
	private double ApplicationFee;
	private double DamageDeposit;
	private String Description;
	private int Availability;
	private Date AvailableDate;
	private int AgentId;
	private ArrayList<Amenity> Amenities;
	private ArrayList<CommunityFeature> CommunityFeatures;
	private ArrayList<Review> Reviews;
	
	public Apartment(int id, String landlord, String aptNumber, String aptType, String address, String city,
			String state, String area, String bathrooms, double pricePerMonth, double applicationFee,
			double damageDeposit, String description, int availability, Date availableDate, int agentId) {
		super();
		Id = id;
		Landlord = landlord;
		AptNumber = aptNumber;
		AptType = aptType;
		Address = address;
		City = city;
		State = state;
		Area = area;
		Bathrooms = bathrooms;
		PricePerMonth = pricePerMonth;
		ApplicationFee = applicationFee;
		DamageDeposit = damageDeposit;
		Description = description;
		Availability = availability;
		AvailableDate = availableDate;
		AgentId = agentId;
	}
	
	public Apartment(int id, String landlord, String aptNumber, String aptType, String address, String city,
			String state, String area, String bathrooms, double pricePerMonth, double applicationFee,
			double damageDeposit, String description, int availability, Date availableDate, int agentId,
			ArrayList<Amenity> amenities, ArrayList<CommunityFeature> communityFeatures, ArrayList<Review> reviews) {
		super();
		Id = id;
		Landlord = landlord;
		AptNumber = aptNumber;
		AptType = aptType;
		Address = address;
		City = city;
		State = state;
		Area = area;
		Bathrooms = bathrooms;
		PricePerMonth = pricePerMonth;
		ApplicationFee = applicationFee;
		DamageDeposit = damageDeposit;
		Description = description;
		Availability = availability;
		AvailableDate = availableDate;
		AgentId = agentId;
		Amenities = amenities;
		CommunityFeatures = communityFeatures;
		Reviews = reviews;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLandlord() {
		return Landlord;
	}
	public void setLandlord(String landlord) {
		Landlord = landlord;
	}
	public String getAptNumber() {
		return AptNumber;
	}
	public void setAptNumber(String aptNumber) {
		AptNumber = aptNumber;
	}
	public String getAptType() {
		return AptType;
	}
	public void setAptType(String aptType) {
		AptType = aptType;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getBathrooms() {
		return Bathrooms;
	}
	public void setBathrooms(String bathrooms) {
		Bathrooms = bathrooms;
	}
	public double getPricePerMonth() {
		return PricePerMonth;
	}
	public void setPricePerMonth(double pricePerMonth) {
		PricePerMonth = pricePerMonth;
	}
	public double getApplicationFee() {
		return ApplicationFee;
	}
	public void setApplicationFee(double applicationFee) {
		ApplicationFee = applicationFee;
	}
	public double getDamageDeposit() {
		return DamageDeposit;
	}
	public void setDamageDeposit(double damageDeposit) {
		DamageDeposit = damageDeposit;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getAvailability() {
		return Availability;
	}
	public void setAvailability(int availability) {
		Availability = availability;
	}
	public Date getAvailableDate() {
		return AvailableDate;
	}
	public void setAvailableDate(Date availableDate) {
		AvailableDate = availableDate;
	}
	public int getAgentId() {
		return AgentId;
	}
	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
	public ArrayList<Amenity> getAmenities() {
		return Amenities;
	}
	public void setAmenities(ArrayList<Amenity> amenities) {
		Amenities = amenities;
	}
	public ArrayList<CommunityFeature> getCommunityFeatures() {
		return CommunityFeatures;
	}
	public void setCommunityFeatures(ArrayList<CommunityFeature> communityFeatures) {
		CommunityFeatures = communityFeatures;
	}
	public ArrayList<Review> getReviews() {
		return Reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		Reviews = reviews;
	}
	
	public static Apartment getApartment(int apartmentId) {
		Apartment apartment = null;
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Apartments where Apartments.Id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, apartmentId);
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
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
			
			apartment = new Apartment(id, landlord, aptNumber, aptType, address, city, state, 
												area, bathrooms, pricePerMonth, applicationFee, damageDeposit,
												description,  availability, availabilityDate, agentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return apartment;
	}

}
