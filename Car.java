
// Car object class 

public class Car extends Vehicle {

	int seatCap;
	
	
	public Car(String description, int mpg, String vin, Reservation resv, int seatCap) {
			super(description,mpg,vin,resv);
			
			this.seatCap=seatCap;
	}
	
	public String toString() {
		
		return" Description: "+super.getdescription()+ "Mpg: "+super.getMpg()+ " VIN: "+super.getVIN()+" Seat Capacity: "+seatCap;
		
	}
	
