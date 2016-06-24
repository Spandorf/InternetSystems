package model;

public class Amenity {
	private int Id;
	private String Name;
	private String Description;
	
	public Amenity(int id, String name, String description) {
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
	
	public static ArrayList<Amenity> getAmenities(int apartmentId) {
		ArrayList<Amenity> amenities = new ArrayList<Amenity>();
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT Amenities.Id AS Id, Amenities.Name AS Name, Amenities.Description AS Description from ApartmentAmenities JOIN Amenities ON ApartmentAmenities.AmenityId = Amenities.Id WHERE ApartmentAmenities.ApartmentId = ? AND ApartmentAmenities.Availablility = 1";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, apartmentId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				Amenity amenity = null;
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String description = rs.getString("Description");
				amenity = new Amenity(id, name, description);
				amenities.add(amenity);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return amenities;
	}
}
