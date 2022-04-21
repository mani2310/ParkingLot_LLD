package main.java.com.processor;

import main.java.com.constants.ParkingLotConstants;
import main.java.com.models.Vehicle;
import main.java.com.service.ParkingLotService;

public class CommandProcessor {
	ParkingLotService parkingLotService = new ParkingLotService();
	
	public void processCommand(String[] input)
	{
		String command = input[0];
		if(command.equals(ParkingLotConstants.CREATE_PARKING_LOT))
		{
		int parkingLotCapacity = Integer.parseInt(input[1]);
		parkingLotService.createParkingSlot(parkingLotCapacity);
		}
		else if(command.equals(ParkingLotConstants.PARK))
		{
			String regNumber = input[1];
			String color = input[2];
			parkingLotService.parkVehicle(new Vehicle(regNumber,color));
		}
		else if(command.equals(ParkingLotConstants.LEAVE))
		{
			Integer slotNumber = Integer.parseInt(input[1]);
			parkingLotService.removeEmptySlot(slotNumber);
		}
		else if(command.equals(ParkingLotConstants.STATUS))
		{
			parkingLotService.getSlotStatus();
		}
		else if(command.equals(ParkingLotConstants.REG_NUMBER_FOR_CARS_WITH_COLOR))
		{
			String color = input[1];
			parkingLotService.getRegistrationNumberByColor(color);
		}
		else if(command.equals(ParkingLotConstants.SLOT_NUMBERS_FOR_CARS_WITH_COLOR))
		{
			String color = input[1];
			parkingLotService.getSlotNumbersByColor(color);
		}
		else if(command.equals(ParkingLotConstants.SLOT_NUMBER_FOR_REGISTATION_NUMBER))
		{
			String registrationNumber = input[1];
			parkingLotService.getSlotNumberByRegNumber(registrationNumber);
		}
	}

}
