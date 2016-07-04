package model;

public class Status {
	private Boolean Success;
	private String ErrorMessage;
	
	public Status(Boolean success, String errorMessage) {
		super();
		Success = success;
		ErrorMessage = errorMessage;
	}
	
	public Boolean getSuccess() {
		return Success;
	}
	public void setSuccess(Boolean success) {
		Success = success;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
}
