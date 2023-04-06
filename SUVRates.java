public class SUVRates extends VehicleRates {
	
	public SUVRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
		    double daily_insur_rate) {
				
				super(daily_rate, weekly_rate, monthly_rate, mileage_chrg, daily_insur_rate);
			}

			
			public String toString() {
				
				return " Daily Rate: " +super.getDailyRate()+ " Weekly Rate: "+super.getWeeklyRate()+ " Monthly Rate: " +super.getMonthlyRate()+
		" Mileage Charge: "	+super.getMileageChrg()+ " Daily Insurance Rate: " +super.getDailyInsurRate();
						
			
			}

}
