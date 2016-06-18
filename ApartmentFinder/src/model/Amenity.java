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
}
