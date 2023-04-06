public class RentalDetails {
	
	private int vehicle;
	private TimeSpan rental_period;
	private int estimatedNum_Miles;
	private boolean insur_option;
	private boolean primeCustomer;
	
	
	public RentalDetails(int vehicle, TimeSpan rental_period, int estimatedNum_Miles, boolean insur_option, boolean primeCustomer) {
		
		this.vehicle=vehicle;
		this.rental_period =rental_period;
		this.estimatedNum_Miles= estimatedNum_Miles;
		this.insur_option= insur_option;
		this.primeCustomer= primeCustomer;
	}
	
	
	public int getVehicle() {
		
		return vehicle;
		
	}
	
	public TimeSpan getRentalPeriod() {
		
		return rental_period;
		
	}
	
	public int getEstimatedMiles() {
		
		return estimatedNum_Miles;
		
	}
	
	public boolean getInsurOption(){
		
		
		return insur_option;
	}
	
	public boolean getPrimeCustomer() {
		
		
		return primeCustomer;
	}

}
