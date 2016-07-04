package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

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
		this.Id = id;
	}
	public String getReviewerName() {
		return ReviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.ReviewerName = reviewerName;
	}
	public Date getReviewDate() {
		return ReviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.ReviewDate = reviewDate;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		this.Rating = rating;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		this.Review = review;
	}
	public int getApartmentId() {
		return ApartmentId;
	}
	public void setApartmentId(int apartmentId) {
		this.ApartmentId = apartmentId;
	}
	
	public static ArrayList<Review> getReviews(int apartmentId) {
		ArrayList<Review> reviews = new ArrayList<Review>();
		Connection conn = DBUtil.getConnection();
		try {
			String query = "SELECT * from Reviews WHERE Reviews.ApartmentId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, apartmentId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				Review review = null;
				int id = rs.getInt("Id");
				String name = rs.getString("ReviewerName");
				Date date = rs.getDate("ReviewDate");
				int rating = rs.getInt("Rating");
				String reviewText = rs.getString("Review");
				review = new Review(id, name, date, rating, reviewText, apartmentId);
				reviews.add(review);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reviews;
	}
}
