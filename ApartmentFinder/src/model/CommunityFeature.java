package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class CommunityFeature {
	private int Id;
	private String Name;
	private String Description;
	
	public CommunityFeature(int id, String name, String description) {
		super();
		Id = id;
		Name = name;
		Description = description;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public static ArrayList<CommunityFeature> getCommunityFeatures(int apartmentId) {
		ArrayList<CommunityFeature> commFeatures = new ArrayList<CommunityFeature>();
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT CommunityFeatures.Id AS Id, CommunityFeatures.Name AS Name, CommunityFeatures.Description AS Description from ApartmentCommunityFeatures JOIN CommunityFeatures ON ApartmentCommunityFeatures.AmenityId = CommunityFeatures.Id WHERE ApartmentCommunityFeatures.ApartmentId = ? AND ApartmentCommunityFeatures.Availablility = 1";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, apartmentId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				CommunityFeature commFeature = null;
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String description = rs.getString("Description");
				commFeature = new CommunityFeature(id, name, description);
				commFeatures.add(commFeature);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commFeatures;
	}
}
