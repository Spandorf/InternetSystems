package model;

import model.CreditCard;
import model.Apartment;

public class TransactionInfo {
	private Apartment apartment;
	private Application application;
	
	public TransactionInfo(Apartment apartment, Application application) {
		super();
		this.apartment = apartment;
		this.application = application;
	}
	
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public static TransactionInfo getTransactionInfo(int apartmentId, int leaseTerm) {
		Apartment apartment = Apartment.getApartment(apartmentId);
		double cost = apartment.getApplicationFee();
		Application application = new Application(0, apartment, 0, null, null, 0, null, leaseTerm, cost, null, 1);
		TransactionInfo transInfo = new TransactionInfo(apartment, application);
		return transInfo;
	}
}
