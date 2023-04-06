public class CurrentRates {
	
	private VehicleRates[ ]  rates = new VehicleRates[3];   
	
	public CurrentRates(CarRates cRate,SUVRates suvRates,TruckRates truckRates) {
		
		rates [0] = cRate;
		rates [1] = suvRates;
		rates [2] = truckRates;
	}
	
	public CurrentRates() {
		
	CarRates c1= new CarRates(22.95,159.95,514.95,0.15,14.95);
	SUVRates s1 = new SUVRates(29.95,189.95,679.95,0.15,14.95);
	TruckRates t1= new TruckRates(35.95,224.95,787.95,0.26,21.95);
	rates [0] = c1;
	rates [1] = s1;
	rates [2] = t1;
	}
	
	
	public  VehicleRates  getCarRates() { 
		
		return rates[0];
	}
	
	public VehicleRates  getSUVRates() { 
		
		return rates[1];
	}
	
	public VehicleRates  getTruckRates() { 
		
		return rates[2];
	}
	
	public void updateCarRates(VehicleRates r){ 
		
		rates [0]= r;
	}
	
	public void updateSUVRates(VehicleRates r){ 
		
		rates [1]= r;
	}
	
	public void updateTruckRates(VehicleRates r){ 
		
		rates [2]= r;
	}


	public  double calcEstimatedCost(int vehicleType,TimeSpan estimatedRentalPeriod, int estimatedNumMiles,
            boolean dailyInsur, boolean primeCustomer) {
		
		if(vehicleType==1) {

	         if(estimatedRentalPeriod.getimeUnit()=='d') {

	            if(dailyInsur && primeCustomer == true){
	                if(estimatedNumMiles > 100)
	                    return (getCarRates().getDailyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	                if(estimatedNumMiles < 100)
	                    return (getCarRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + (getCarRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	            }
	            else if(dailyInsur == true && primeCustomer == false){
	                return (getCarRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	            }
	            else if(primeCustomer ==true && dailyInsur ==false){
	                if(estimatedNumMiles > 100)
	                    return (getCarRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg());
	                if(estimatedNumMiles < 100)
	                    return (getCarRates().getDailyRate()* estimatedRentalPeriod.getimeUnit());
	            }
	            else
	                return (getCarRates().getDailyRate()*estimatedRentalPeriod.getimeUnit())+ (getCarRates().getMileageChrg()*estimatedNumMiles);
	                
	         } if(estimatedRentalPeriod.getimeUnit()=='w') {

		            if(dailyInsur && primeCustomer == true){
		                if(estimatedNumMiles > 100)
		                    return (getCarRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg()) + (getCarRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		                if(estimatedNumMiles < 100)
		                    return (getCarRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + (getCarRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		            }
		            else if(dailyInsur == true && primeCustomer == false){
		                return (getCarRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getCarRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		            }
		            else if(primeCustomer ==true && dailyInsur ==false){
		                if(estimatedNumMiles > 100)
		                    return (getCarRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg());
		                if(estimatedNumMiles < 100)
		                    return (getCarRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit());
		            }
		            else
		                return (getCarRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit())+ (getCarRates().getMileageChrg()*estimatedNumMiles);
		                
		         } if(estimatedRentalPeriod.getimeUnit()=='m') {

			            if(dailyInsur && primeCustomer == true){
			                if(estimatedNumMiles > 100)
			                    return (getCarRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg()) + (getCarRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			                if(estimatedNumMiles < 100)
			                    return (getCarRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + (getCarRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
			            }
			            else if(dailyInsur == true && primeCustomer == false){
			                return (getCarRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getCarRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			            }
			            else if(primeCustomer ==true && dailyInsur ==false){
			                if(estimatedNumMiles > 100)
			                    return (getCarRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg());
			                if(estimatedNumMiles < 100)
			                    return (getCarRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit());
			            }
			            else
			                return (getCarRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit())+ (getCarRates().getMileageChrg()*estimatedNumMiles);
			                
			         }
	}
		if(vehicleType==2) {

	         if(estimatedRentalPeriod.getimeUnit()=='d') {

	            if(dailyInsur && primeCustomer == true){
	                if(estimatedNumMiles > 100)
	                    return (getSUVRates().getDailyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	                if(estimatedNumMiles < 100)
	                    return (getSUVRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + (getSUVRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	            }
	            else if(dailyInsur == true && primeCustomer == false){
	                return (getSUVRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getSUVRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	            }
	            else if(primeCustomer ==true && dailyInsur ==false){
	                if(estimatedNumMiles > 100)
	                    return (getSUVRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg());
	                if(estimatedNumMiles < 100)
	                    return (getSUVRates().getDailyRate()* estimatedRentalPeriod.getimeUnit());
	            }
	            else
	                return (getSUVRates().getDailyRate()*estimatedRentalPeriod.getimeUnit())+ (getCarRates().getMileageChrg()*estimatedNumMiles);
	                
	         } if(estimatedRentalPeriod.getimeUnit()=='w') {

		            if(dailyInsur && primeCustomer == true){
		                if(estimatedNumMiles > 100)
		                    return (getSUVRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg()) + (getSUVRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		                if(estimatedNumMiles < 100)
		                    return (getSUVRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + (getSUVRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		            }
		            else if(dailyInsur == true && primeCustomer == false){
		                return (getSUVRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getSUVRates().getMileageChrg()) + (getSUVRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		            }
		            else if(primeCustomer ==true && dailyInsur ==false){
		                if(estimatedNumMiles > 100)
		                    return (getSUVRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg());
		                if(estimatedNumMiles < 100)
		                    return (getSUVRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit());
		            }
		            else
		                return (getSUVRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit())+ (getSUVRates().getMileageChrg()*estimatedNumMiles);
		                
		         } if(estimatedRentalPeriod.getimeUnit()=='m') {

			            if(dailyInsur && primeCustomer == true){
			                if(estimatedNumMiles > 100)
			                    return (getSUVRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg()) + (getSUVRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			                if(estimatedNumMiles < 100)
			                    return (getSUVRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + (getSUVRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			            }
			            else if(dailyInsur == true && primeCustomer == false){
			                return (getSUVRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getSUVRates().getMileageChrg()) + (getSUVRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			            }
			            else if(primeCustomer ==true && dailyInsur ==false){
			                if(estimatedNumMiles > 100)
			                    return (getSUVRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg());
			                if(estimatedNumMiles < 100)
			                    return (getSUVRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit());
			            }
			            else
			                return (getSUVRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit())+ (getSUVRates().getMileageChrg()*estimatedNumMiles);
			                
			         }
	}
		
		if(vehicleType==3) {

	         if(estimatedRentalPeriod.getimeUnit()=='d') {

	            if(dailyInsur && primeCustomer == true){
	                if(estimatedNumMiles > 100)
	                    return (getTruckRates().getDailyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	                if(estimatedNumMiles < 100)
	                    return (getTruckRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + (getTruckRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	            }
	            else if(dailyInsur == true && primeCustomer == false){
	                return (getTruckRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*estimatedRentalPeriod.getimeUnit());
	            }
	            else if(primeCustomer ==true && dailyInsur ==false) {
	                if(estimatedNumMiles > 100)
	                    return (getTruckRates().getDailyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg());
	                if(estimatedNumMiles < 100)
	                    return (getTruckRates().getDailyRate()* estimatedRentalPeriod.getimeUnit());
	            }
	            else
	                return (getTruckRates().getDailyRate()*estimatedRentalPeriod.getimeUnit())+ (getTruckRates().getMileageChrg()*estimatedNumMiles);
	                
	         } if(estimatedRentalPeriod.getimeUnit()=='w') {

		            if(dailyInsur && primeCustomer == true){
		                if(estimatedNumMiles > 100)
		                    return (getTruckRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg()) + (getTruckRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		                if(estimatedNumMiles < 100)
		                    return (getTruckRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + (getTruckRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		            }
		            else if(dailyInsur == true && primeCustomer == false){
		                return (getTruckRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getTruckRates().getMileageChrg()) + (getTruckRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit());
		            }
		            else if(primeCustomer ==true && dailyInsur ==false){
		                if(estimatedNumMiles > 100)
		                    return (getTruckRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg());
		                if(estimatedNumMiles < 100)
		                    return (getTruckRates().getWeeklyRate()* estimatedRentalPeriod.getimeUnit());
		            }
		            else
		                return (getTruckRates().getWeeklyRate()*estimatedRentalPeriod.getimeUnit())+ (getTruckRates().getMileageChrg()*estimatedNumMiles);
		                
		         } if(estimatedRentalPeriod.getimeUnit()=='m') {

			            if(dailyInsur && primeCustomer == true){
			                if(estimatedNumMiles > 100)
			                    return (getTruckRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit() ) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg()) + (getTruckRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			                if(estimatedNumMiles < 100)
			                    return (getSUVRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + (getTruckRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			            }
			            else if(dailyInsur == true && primeCustomer == false){
			                return (getTruckRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + (estimatedNumMiles * getTruckRates().getMileageChrg()) + (getSUVRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit());
			            }
			            else if(primeCustomer ==true && dailyInsur ==false){
			                if(estimatedNumMiles > 100)
			                    return (getTruckRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit()) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg());
			                if(estimatedNumMiles < 100)
			                    return (getTruckRates().getMonthlyRate()* estimatedRentalPeriod.getimeUnit());
			            }
			            else
			                return (getTruckRates().getMonthlyRate()*estimatedRentalPeriod.getimeUnit())+ (getTruckRates().getMileageChrg()*estimatedNumMiles);
			          return 0;      
		         }
		}
		return 0.0;
	}
	public double calcActualCost(VehicleRates rates, int numDaysUsed, int NumMilesDriven,
	          boolean dailyInsur, boolean primeCustomer) { 
		
		if (dailyInsur == true && primeCustomer == true) {
			if (numDaysUsed < 7 ) {
		     return numDaysUsed* rates.getDailyRate()+numDaysUsed*rates.getDailyInsurRate();
		
		} else if (numDaysUsed >=7 && numDaysUsed <=30) {
			
			return  numDaysUsed* rates.getWeeklyRate()+numDaysUsed*rates.getDailyInsurRate();
			
			} else return numDaysUsed* rates.getMonthlyRate()+numDaysUsed*rates.getDailyRate();
			
		} if (dailyInsur == true && primeCustomer == false) {
			if (numDaysUsed < 7) {
				
				return numDaysUsed* rates.getDailyRate()+numDaysUsed*rates.getDailyInsurRate()+rates.getMileageChrg();
				
			} else if (numDaysUsed >=7 && numDaysUsed <=30) {
				
			return numDaysUsed* rates.getWeeklyRate()+numDaysUsed*rates.getDailyInsurRate()+rates.getMileageChrg();
				
			} if (dailyInsur == false && primeCustomer == true) {
				
				if (NumMilesDriven < 100 ) {
					
					if(numDaysUsed <7 ) {
						
						return numDaysUsed*rates.getDailyRate();
					}if (numDaysUsed >=7 && numDaysUsed <=30) {
						
						return numDaysUsed*rates.getMonthlyRate();
						
					} 
					
				} 
					
				} if (dailyInsur && primeCustomer == false) {
					
				if(numDaysUsed <7) {
						
						return numDaysUsed*rates.getDailyRate()+numDaysUsed*rates.getMileageChrg();
					} else if (numDaysUsed >=7 && numDaysUsed <=30) {
						
						return numDaysUsed*rates.getWeeklyRate()+numDaysUsed*rates.getMileageChrg();
						
					} else return numDaysUsed*rates.getMonthlyRate()+numDaysUsed*rates.getMileageChrg();
					
				}
				
			}
	
			
			
		return 0.0;
			
		}

	
	
		
		
		
	}




