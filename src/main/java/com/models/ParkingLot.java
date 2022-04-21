package main.java.com.models;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	
	private Integer totalCapacity;
	private Map<Integer, Slot> slots;

	public ParkingLot(int parkingLotCapacity) {
		this.totalCapacity = parkingLotCapacity;
		this.slots = new HashMap<>();
	}

}
