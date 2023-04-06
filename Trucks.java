public class Trucks extends Vehicle{
	
	int loadCap;
	
	
	public Trucks(String description, int mpg, String vin, Reservation resv, int loadCap) {
		super(description,mpg,vin,resv);
		
		this.loadCap=loadCap;
		
}

public String toString() {
	
	return" Description: "+super.getdescription()+ "Mpg: "+super.getMpg()+"VIN: "+super.getVIN()+" ";
	
}

}
