package main.java.com.exception;

public class InvalidVehicleNumber extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidVehicleNumber(String message)
	{
		super(message);
	}

}
