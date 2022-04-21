package main.java.com.strategy;

import java.util.TreeSet;

public class ParkingOrder implements ParkingStrategy{
	
	TreeSet<Integer> slotList;
	
	public ParkingOrder()
	{
		slotList = new TreeSet<>();
	}

	@Override
	public void addSlot(Integer slotNumber) {
		
		this.slotList.add(slotNumber);
	}

	@Override
	public void removeSlot(Integer slotNumber) {
	
		this.slotList.remove(slotNumber);
	}

	@Override
	public Integer getNextSlot() {
	 return this.slotList.first();
	}

}
