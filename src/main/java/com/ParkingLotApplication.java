package main.java.com;

import java.io.IOException;

import main.java.com.exception.InvalidModeException;
import main.java.com.mode.FileMode;
import main.java.com.mode.InteractiveMode;

public class ParkingLotApplication {
	
	public static void main(String[] args) throws IOException
	{
		Boolean interactiveMode = args.length ==0?true:false;
		Boolean fileMode = args.length == 1?true:false;
		if(interactiveMode)
		{
			new InteractiveMode().process();
		}
		else if(fileMode)
		{
			new FileMode(args[0]).process();
		}
		else
		{
		   throw new InvalidModeException();
		}
	}

}
