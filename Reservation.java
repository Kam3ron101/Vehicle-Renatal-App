public class Reservation {
	
	private String creditCardNum; 
	private TimeSpan rentalPeriod; 
	private boolean insuranceSelected; 

	public Reservation(String creditCardNum, TimeSpan rentalPeriod, boolean insuranceSelected) {
		
		this.creditCardNum=creditCardNum;
		this.rentalPeriod =rentalPeriod;
		this.insuranceSelected = insuranceSelected;
		
		
	}
	
	public String getcreditCardNum() {
		
		return creditCardNum;
		
	}
	
	public TimeSpan rentalPeriod() {
		
		return rentalPeriod;
		
	}

	public boolean insuranceSelected() {
		
		return insuranceSelected;
		
	}
	
	public String toString () {
		
		return "Your card Number: "+creditCardNum+ " "+rentalPeriod+" "+(insuranceSelected? "and you do have insurance!": "and you don't have insurance!");
		
	}
	
} 
