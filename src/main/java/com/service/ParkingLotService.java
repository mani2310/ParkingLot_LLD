package main.java.com.service;

import java.util.HashMap;
import java.util.Map;

import main.java.com.exception.InvalidVehicleNumber;
import main.java.com.exception.NoEmptySlotAvailable;
import main.java.com.models.ParkingLot;
import main.java.com.models.Slot;
import main.java.com.models.Vehicle;
import main.java.com.strategy.ParkingOrder;
import main.java.com.strategy.ParkingStrategy;
import main.java.com.validations.InputValidator;

public class ParkingLotService {
	
	private ParkingStrategy parkingStrategy;
	private ParkingLot parkingLot;
	private Map<Integer, Slot> slots;


	public boolean createParkingSlot(ParkingLot parkingLot,int numberOfSlots,ParkingStrategy parkingStrategy) {
		if (!InputValidator.isValidSlotNumber(numberOfSlots))
			return false;
		this.parkingStrategy = parkingStrategy;
		this.parkingLot = parkingLot;
		for (int i = 1; i <= numberOfSlots; i++) {
			parkingStrategy.addSlot(i);
		}
		System.out.printf("Created a parking lot with %s slots %n", numberOfSlots);
		return true;
	}
	
	public boolean parkVehicle(Vehicle vehicle) throws NoEmptySlotAvailable {
        Integer slotNumber = parkingStrategy.getNextSlot();
        Slot newSlot = getSlot(slotNumber);
        newSlot.setParkVehicle(vehicle);
        System.out.printf("Allocated slot number: %d \n", newSlot.getSlotNumber());
        return true;
    }


	public void removeEmptySlot(Integer slotNumber) {
		Slot slot = getSlot(slotNumber);
		slot.setParkVehicle(null);
		parkingStrategy.addSlot(slotNumber);
	}

	public void getRegistrationNumberByColor(String color) {
		for(Slot slot:slots.values())
		{
			Vehicle parkVehicle = slot.getParkVehicle();
			 if (parkVehicle != null && parkVehicle.getColor().equals(color)) {
	               System.out.println(parkVehicle.getRegistrationNumber()+","); 
	            }
		}
		
	}

	public void getSlotNumbersByColor(String color) {
		for(Slot slot:slots.values())
		{
			Vehicle parkVehicle = slot.getParkVehicle();
			 if (parkVehicle != null && parkVehicle.getColor().equals(color)) {
	               System.out.println(slot.getSlotNumber()+","); 
	            }
		}
		
	}

	public void getSlotNumberByRegNumber(String registrationNumber) {
		for(Slot slot:slots.values())
		{
			Vehicle parkVehicle = slot.getParkVehicle();
			 if (parkVehicle != null && parkVehicle.getRegistrationNumber().equals(registrationNumber)) {
	               System.out.println(slot.getSlotNumber()); 
	            }
		}
		throw new InvalidVehicleNumber("Registration number " + registrationNumber + " not found");
	}

	public void getSlotStatus() {
		System.out.println("Slot No.  Registration No");
		slots.values().forEach(slot -> {
			if (!slots.isEmpty()) {
				Vehicle parkVehicle = slot.getParkVehicle();
				if (parkVehicle != null)
					System.out.printf("   %d       %s     %s\n", slot.getSlotNumber(), 
							parkVehicle.getRegistrationNumber(),parkVehicle.getColor());
			}
		});

	}
	
	private Slot getSlot(Integer slotNumber)
	{
		if(!slots.containsKey(slotNumber))
		{
			slots.put(slotNumber, new Slot(slotNumber));
		}
		return slots.get(slotNumber);
	}

}
