package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Apartment;
import model.CreditCard;
import util.DBUtil;

public class Application {
	private int Id;
	private Apartment Apartment;
	private int status;
	private String ApplicationNumber;
	private Date ApplyingDate;
	private int ApplicantId;
	private Date MoveInDate;
	private int LeaseTerm;
	private double Cost;
	private String Notes;
	private int AgentId;
	
	public Application(int id, Apartment apartment, int status, String applicationNumber, Date applyingDate,
			int applicantId, Date moveInDate, int leaseTerm, double cost, String notes, int agentId) {
		super();
		Id = id;
		Apartment = apartment;
		this.status = status;
		ApplicationNumber = applicationNumber;
		ApplyingDate = applyingDate;
		ApplicantId = applicantId;
		MoveInDate = moveInDate;
		LeaseTerm = leaseTerm;
		Cost = cost;
		Notes = notes;
		AgentId = agentId;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Apartment getApartment() {
		return Apartment;
	}
	public void setApartment(Apartment apartment) {
		Apartment = apartment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getApplicationNumber() {
		return ApplicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		ApplicationNumber = applicationNumber;
	}
	public Date getApplyingDate() {
		return ApplyingDate;
	}
	public void setApplyingDate(Date applyingDate) {
		ApplyingDate = applyingDate;
	}
	public int getApplicantId() {
		return ApplicantId;
	}
	public void setApplicantId(int applicantId) {
		ApplicantId = applicantId;
	}
	public Date getMoveInDate() {
		return MoveInDate;
	}
	public void setMoveInDate(Date moveInDate) {
		MoveInDate = moveInDate;
	}
	public int getLeaseTerm() {
		return LeaseTerm;
	}
	public void setLeaseTerm(int leaseTerm) {
		LeaseTerm = leaseTerm;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public int getAgentId() {
		return AgentId;
	}
	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
	
	public static int getNumApps(int aptId){
		Connection conn = DBUtil.getConnection();
		int count = 0;
		try {
			String query = "select * from Applications where Applications.ApartmentId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, aptId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				count++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Application getAppByAppNum(String applNum) {
		Application app = null;
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Applications where Applications.ApplicationNumber LIKE ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "%" + applNum + "%");
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			int id = rs.getInt("Id");
			int aptId = rs.getInt("ApartmentId");
			int status = rs.getInt("Status");
			String appNum = rs.getString("ApplicationNumber");
			Date applyingDate = rs.getDate("ApplyingDate");
			int applicantId = rs.getInt("ApplicantId");
			Date moveInDate = rs.getDate("MoveInDate");
			int leaseTerm = rs.getInt("LeaseTerm");
			double cost = rs.getDouble("Cost");
			String notes = rs.getString("Notes");
			int agentId = rs.getInt("AgentId");
			
			Apartment apartment = model.Apartment.getApartment(aptId);
			
			app = new Application(id, apartment, status, appNum, applyingDate,
					applicantId, moveInDate, leaseTerm, cost, notes, agentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return app;
	}
	
	public static ArrayList<Application> getUserApps(int userId) {
		ArrayList<Application> apps = new ArrayList<Application>();
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Applications where Applications.ApplicantId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				Application app = null;
				int id = rs.getInt("Id");
				int aptId = rs.getInt("ApartmentId");
				int status = rs.getInt("Status");
				String appNum = rs.getString("ApplicationNumber");
				Date applyingDate = rs.getDate("ApplyingDate");
				int applicantId = rs.getInt("ApplicantId");
				Date moveInDate = rs.getDate("MoveInDate");
				int leaseTerm = rs.getInt("LeaseTerm");
				double cost = rs.getDouble("Cost");
				String notes = rs.getString("Notes");
				int agentId = rs.getInt("AgentId");
				Apartment apartment = model.Apartment.getApartment(aptId);
				
				app = new Application(id, apartment, status, appNum, applyingDate,
						applicantId, moveInDate, leaseTerm, cost, notes, agentId);
				
				apps.add(app);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return apps;
	}
	
	public static Application getApp(int appId) {
		Application app = null;
		Connection conn = DBUtil.getConnection();
		try {
			String query = "select * from Applications where Applications.Id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, appId);
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			int id = rs.getInt("Id");
			int aptId = rs.getInt("ApartmentId");
			int status = rs.getInt("Status");
			String appNum = rs.getString("ApplicationNumber");
			Date applyingDate = rs.getDate("ApplyingDate");
			int applicantId = rs.getInt("ApplicantId");
			Date moveInDate = rs.getDate("MoveInDate");
			int leaseTerm = rs.getInt("LeaseTerm");
			double cost = rs.getDouble("Cost");
			String notes = rs.getString("Notes");
			int agentId = rs.getInt("AgentId");
			
			preparedStatement.close();
			
			Apartment apartment = model.Apartment.getApartment(aptId);
			
			app = new Application(id, apartment, status, appNum, applyingDate,
					applicantId, moveInDate, leaseTerm, cost, notes, agentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return app;
	}
	
	public static void addApplication(Application app) {
		
		Connection conn = DBUtil.getConnection();
		try {
			java.sql.Timestamp appDate = new java.sql.Timestamp(new java.util.Date().getTime());
			String query = "insert into Applications (ApartmentId, Status, ApplicationNumber, ApplyingDate, ApplicantId, MoveInDate, LeaseTerm, Cost, Notes, AgentId ) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, app.getApartment().getId());
			preparedStatement.setInt(2, app.getStatus());
			preparedStatement.setString(3, app.getApplicationNumber());
			preparedStatement.setTimestamp(4, appDate);
			preparedStatement.setInt(5, app.getApplicantId());
			preparedStatement.setTimestamp(6, appDate);
			preparedStatement.setInt(7, app.getLeaseTerm());
			preparedStatement.setDouble(8, app.getCost());
			preparedStatement.setString(9, app.getNotes());
			preparedStatement.setInt(10, app.getAgentId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void cancelApplication(Application app) {
		
		Connection conn = DBUtil.getConnection();
		try {
			String query = "delete from Applications where Id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, app.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			query = "Select * from CreditCards where UserId=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, app.getApplicantId());
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			int balance = rs.getInt("Balance");
			int ccId = rs.getInt("Id");
			
			preparedStatement.close();
			
			double newbalance = app.getCost() + balance;
			CreditCard.updateBalance(ccId, newbalance);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
