package main.java.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.com.exception.NoEmptySlotAvailable;
import main.java.com.models.Slot;
import main.java.com.models.Vehicle;
import main.java.com.strategy.ParkingOrder;
import main.java.com.strategy.ParkingStrategy;
import main.java.com.validations.InputValidator;

public class ParkingLotService {
	
	private ParkingStrategy parkingStrategy;
	private static Map<Integer, Slot> slots = new HashMap<>();

	public ParkingLotService()
	{
		this.parkingStrategy = new ParkingOrder();
	}

	public boolean createParkingSlot(int numberOfSlots) {
		if (!InputValidator.isValidSlotNumber(numberOfSlots))
			return false;
		for (int i = 1; i <= numberOfSlots; i++) {
			parkingStrategy.addSlot(i);
		}
		System.out.printf("Created a parking lot with %s slots %n", numberOfSlots);
		return true;
	}
	
	public void parkVehicle(Vehicle vehicle) throws NoEmptySlotAvailable {
        Integer slotNumber = parkingStrategy.getNextSlot();
        if(slotNumber.equals(-1))
        	System.out.println("Sorry, parking lot is full");
        else {
        Slot newSlot = getSlot(slotNumber);
        newSlot.setParkVehicle(vehicle);
        System.out.printf("Allocated slot number: %d \n", newSlot.getSlotNumber());
        parkingStrategy.removeSlot(slotNumber);
        }
    }


	public void removeEmptySlot(Integer slotNumber) {
		Slot slot = getSlot(slotNumber);
		slot.setParkVehicle(null);
		parkingStrategy.addSlot(slotNumber);
		System.out.println("Slot number " + slotNumber + " is free");
	}

	public void getRegistrationNumberByColor(String color) {
		for(Slot slot:ParkingLotService.slots.values())
		{
			Vehicle parkVehicle = slot.getParkVehicle();
			 if (parkVehicle != null && parkVehicle.getColor().equals(color)) {
	               System.out.println(parkVehicle.getRegistrationNumber()+","); 
	            }
		}
		
	}

	public void getSlotNumbersByColor(String color) {
		for(Slot slot:ParkingLotService.slots.values())
		{
			Vehicle parkVehicle = slot.getParkVehicle();
			 if (parkVehicle != null && parkVehicle.getColor().equals(color)) {
	               System.out.print(slot.getSlotNumber()+","); 
	            }
		}
		
	}

	public void getSlotNumberByRegNumber(String registrationNumber) {
		List<Slot> list = ParkingLotService.slots.values().stream().filter(slot -> slot.getParkVehicle().
				getRegistrationNumber().equals(registrationNumber)).collect(Collectors.toList());
		if(list != null && list.size() == 1)
		{
			 System.out.println(list.get(0).getSlotNumber()); 
		}
		else
			System.out.println("Not Found");
	}

	public void getSlotStatus() {
		System.out.println("Slot No.  Registration No   Color");
		ParkingLotService.slots.values().forEach(slot -> {
			if (!ParkingLotService.slots.isEmpty()) {
				Vehicle parkVehicle = slot.getParkVehicle();
				if (parkVehicle != null)
					System.out.printf("   %d       %s     %s\n", slot.getSlotNumber(), 
							parkVehicle.getRegistrationNumber(),parkVehicle.getColor());
			}
		});

	}
	
	private Slot getSlot(Integer slotNumber)
	{
		if(!ParkingLotService.slots.containsKey(slotNumber))
		{
			ParkingLotService.slots.put(slotNumber, new Slot(slotNumber));
		}
		return ParkingLotService.slots.get(slotNumber);
	}

}
