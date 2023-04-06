public class SUV extends Vehicle{
	
int seatCap;
int cargoCap;	
	
	public SUV(String description, int mpg, String vin, Reservation resv, int seatCap, int cargoCap) {
			super(description,mpg,vin,resv);
			
			this.seatCap=seatCap;
			this.cargoCap=cargoCap;
	}
	
	public String toString() {
		
		return" Description: "+super.getdescription()+ "Mpg: "+super.getMpg()+" VIN: "+super.getVIN()+"Seat Capacity: "+seatCap;
		
	}
	

}
