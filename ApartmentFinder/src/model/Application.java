package model;

import java.util.Date;

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
	
	public Application(int id, model.Apartment apartment, int status, String applicationNumber, Date applyingDate,
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
	
	
}
