package main.java.com.processor;

import main.java.com.models.ParkingLot;
import main.java.com.models.Vehicle;
import main.java.com.service.ParkingLotService;
import main.java.com.strategy.ParkingOrder;

public class CommandProcessor {
	
	public void processCommand(String[] input)
	{
		String command = input[0];
		if(command.equals("create_parking_lot"))
		{
		int parkingLotCapacity = Integer.parseInt(input[1]);
		ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
	    new ParkingLotService().createParkingSlot(parkingLot,parkingLotCapacity,new ParkingOrder());
		}
		else if(command.equals("park"))
		{
			String regNumber = input[1];
			String color = input[2];
			new ParkingLotService().parkVehicle(new Vehicle(regNumber,color));
		}
		else if(command.equals("leave"))
		{
			Integer slotNumber = Integer.parseInt(input[1]);
			new ParkingLotService().removeEmptySlot(slotNumber);
		}
		else if(command.equals("status"))
		{
			new ParkingLotService().getSlotStatus();
		}
		else if(command.equals("registration_numbers_for_cars_with_colour"))
		{
			String color = input[1];
			new ParkingLotService().getRegistrationNumberByColor(color);
		}
		else if(command.equals("slot_numbers_for_cars_with_colour"))
		{
			String color = input[1];
			new ParkingLotService().getSlotNumbersByColor(color);
		}
		else if(command.equals("slot_number_for_registration_number"))
		{
			String registrationNumber = input[1];
			new ParkingLotService().getSlotNumberByRegNumber(registrationNumber);
		}
	}

}
