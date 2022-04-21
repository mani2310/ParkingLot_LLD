package main.java.com.strategy;

import java.util.TreeSet;

public class ParkingOrder implements ParkingStrategy{
	
	public static TreeSet<Integer> slotList = new TreeSet<>();

	@Override
	public void addSlot(Integer slotNumber) {
		
		ParkingOrder.slotList.add(slotNumber);
	}

	@Override
	public void removeSlot(Integer slotNumber) {
	
		ParkingOrder.slotList.remove(slotNumber);
	}

	@Override
	public Integer getNextSlot() {
	 if(ParkingOrder.slotList.isEmpty())
		 return -1;
	 return ParkingOrder.slotList.first();
	}

}
