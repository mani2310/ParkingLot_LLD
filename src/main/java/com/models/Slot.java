package main.java.com.models;

public class Slot {
	
    private Integer slotNumber;
    private boolean isEmpty;
    private Vehicle parkVehicle;
    
    public Slot(Integer number)
    {
        this.slotNumber = number;
    }
    
	public Integer getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(Integer number) {
		this.slotNumber = number;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public Vehicle getParkVehicle() {
		return parkVehicle;
	}
	public void setParkVehicle(Vehicle parkVehicle) {
		this.parkVehicle = parkVehicle;
	}

	public void placeVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}
    
    

}
