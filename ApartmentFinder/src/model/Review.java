package model;

import java.sql.Date;

public class Review {
	private int Id;
	private String ReviewerName;
	private Date ReviewDate;
	private int Rating;
	private String Review;
	private int ApartmentId;
	
	public Review(int id, String reviewerName, Date reviewDate, int rating, String review, int apartmentId) {
		super();
		Id = id;
		ReviewerName = reviewerName;
		ReviewDate = reviewDate;
		Rating = rating;
		Review = review;
		ApartmentId = apartmentId;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getReviewerName() {
		return ReviewerName;
	}
	public void setReviewerName(String reviewerName) {
		ReviewerName = reviewerName;
	}
	public Date getReviewDate() {
		return ReviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		ReviewDate = reviewDate;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	public int getApartmentId() {
		return ApartmentId;
	}
	public void setApartmentId(int apartmentId) {
		ApartmentId = apartmentId;
	}
}
