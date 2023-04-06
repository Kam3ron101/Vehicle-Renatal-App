public abstract class Vehicle {

	
	private String description; 
	private int mpg; 
	private String vin;
	private Reservation resv; 

	
	public Vehicle (String description, int mpg, String vin, Reservation resv) {
		
		this.description= description;
		this.mpg = mpg;
		this.vin= vin;
		this.resv = resv;
		
	}

   
	public int getMpg() {  
		
		return mpg;
		
	}
	
	public String getdescription() {
		
	return description;	
		
	}
	public String getVIN() { 
		
		return vin;
	}
	public Reservation getReservation() { 
		
		return resv;
	}
	public abstract String toString(); 
	public boolean isReserved() {
		
		return (resv==null);
	}
	public void reserve(Reservation r) {
		
		if(resv == null) {
			resv=r;
		}
	}
	public void cancelReservation() { 
		
		resv=null;
	}
	
	public void setQuotedRates(VehicleRates cost) {
		
		
		
		
	}
}
