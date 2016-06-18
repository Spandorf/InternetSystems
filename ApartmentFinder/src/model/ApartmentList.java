package model;

import java.util.ArrayList;

public class ApartmentList {
	private ArrayList<Apartment> Apartments;

	public ApartmentList(ArrayList<Apartment> apartments) {
		super();
		Apartments = apartments;
	}

	public ArrayList<Apartment> getApartments() {
		return Apartments;
	}
	public void setApartments(ArrayList<Apartment> apartments) {
		Apartments = apartments;
	}
}
