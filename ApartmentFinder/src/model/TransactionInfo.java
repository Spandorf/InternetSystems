package model;

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
		// TODO
		
		return null;
	}
}
