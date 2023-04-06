public class ReservationDetails {

	private String VIN;
	private int creditcard_num;
	private TimeSpan rentalPeriod;
	private boolean insurSelected;
	
	
	public ReservationDetails(String VIN, int creditcard_num, TimeSpan rentalPeriod, boolean insurSelected) {
		
		this.VIN = VIN;
		this.creditcard_num= creditcard_num;
		this.rentalPeriod= rentalPeriod;
		this.insurSelected= insurSelected;
		
		
	}
	
	public String getVIN() {
		
		return VIN;
	}
	
   public int getCreditCardNum() {
		
		return creditcard_num;
	}
	
   public boolean getinsurSelcted() {
		
		return insurSelected;
	}
	
	public TimeSpan getrentalPeriod() {
		
		return rentalPeriod;
	}
}
