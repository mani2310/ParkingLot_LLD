package main.java.com.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.com.constants.ParkingLotConstants;
import main.java.com.processor.CommandProcessor;
import main.java.com.validations.InputValidator;



public class InteractiveMode implements Mode{

	@Override
	public void process() throws IOException {
		
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	      String inputLine = reader.readLine();
	      if(InputValidator.isValidInput(inputLine))
	      {
	    	  String[] input = inputLine.split(" ");
	    	  new CommandProcessor().processCommand(input);
	    	  if (input.equals(ParkingLotConstants.EXIT)) {
	    		  break;
	    	  }
	    }
		
	}
	}

}
