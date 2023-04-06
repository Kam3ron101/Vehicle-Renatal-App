import java.util.Scanner;

public class SystemInterface {
	Scanner in = new Scanner(System.in);
	
	private static CurrentRates agency_rates;
	private static Vehicles agency_vehicles;
	private static Accounts accounts;
	private static Transactions transactions_history;

	// used to init static variables (in place of a constructor)
	public static void initSystem(CurrentRates r, Vehicles v,  Accounts a, Transactions t) {
		agency_rates = r;
		agency_vehicles = v;
		accounts = a;
		transactions_history = t;
	}
	
// Note that methods makeReservation, cancelReservation, addAccount, and updateXXXRates return 
// an acknowledgement of successful completion of the requested action (e.g. �Vehicle QK3FL4273ME
// successfully reserved�). Method processReturnedVehicle returns the final cost for the returned 
// vehicle (e.g., �Total charge for VIN QK3FL4273ME for 3 days, 233 miles @  0.15/mile and daily
// insurance @ 14.95/day (with 100 miles credit as Prime customer) = $xxx.xx.)
	// Current Rates Related Methods
	public static String[ ] getCarRates() {  
		
		return new String[] {agency_rates.getCarRates().toString()};
	}
	public static String[ ] getSUVRates() { return new String[] 
			
			{agency_rates.getSUVRates().toString()}; 
	
	}
	public static String[ ] getTruckRates() { return new String[] 
			
			{agency_rates.getTruckRates().toString()}; }

	public static String[ ] updateCarRates(VehicleRates r) { 
		
		 agency_rates.updateCarRates(r);
		 
		 return new String[] { "Car Rates Updated!" };
		
	}
	public static String[ ] updateSUVRates(VehicleRates r) { 
		
		agency_rates.updateSUVRates(r);
		
		return new String[] { "SUV Rates Updated!" };
	}
	public static String[ ] updateTruckRates(VehicleRates r) { 
		
		agency_rates.updateTruckRates(r);
		
		return new String [] { "Truck Rates Updated!" };
	}

public static String[ ] estimatedRentalCost(RentalDetails details) { 
	
	
	
	
	agency_rates.calcEstimatedCost(details.getVehicle(), details.getRentalPeriod(), details.getEstimatedMiles(), details.getInsurOption(), details.getPrimeCustomer());
	
	return new String [] { ""+agency_rates.calcEstimatedCost(details.getVehicle(), details.getRentalPeriod(), details.getEstimatedMiles(), details.getInsurOption(), details.getPrimeCustomer())
 };
} 

public static String[ ] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) throws VINNotFoundException { 
	
	String cost;
	
	

    VehicleRates rates = null;
    
    
    if (!agency_vehicles.getVehicle(vin).getVIN().equals(vin)) {

        throw new VINNotFoundException();
    

    } else if (agency_vehicles.getVehicle(vin) instanceof Car) {
    	String creditcard_num = null;
        rates = agency_rates.getCarRates();

        String days = num_days_used + " days";

        cost = "$" + (agency_rates.calcActualCost(rates, num_days_used, num_miles_driven, agency_vehicles.getVehicle(vin).getReservation().insuranceSelected(), accounts.getAccount(agency_vehicles.getVehicle(vin).getReservation().getcreditCardNum()).primeCustomer()));

        Transaction trans = new Transaction(creditcard_num, accounts.getAccount(creditcard_num).getCompanyName(), "Car", days, cost);

        transactions_history.add(trans);

        agency_vehicles.getVehicle(vin).cancelReservation();

        System.out.println("Vehicle has been returned");

    } else if (agency_vehicles.getVehicle(vin) instanceof SUV) {
    	String creditcard_num = null;
        rates = agency_rates.getCarRates();

        String days = num_days_used + " days";

        cost = "$" + (agency_rates.calcActualCost(rates, num_days_used, num_miles_driven, agency_vehicles.getVehicle(vin).getReservation().insuranceSelected(), accounts.getAccount(agency_vehicles.getVehicle(vin).getReservation().getcreditCardNum()).primeCustomer()));

        Transaction trans = new Transaction(creditcard_num, accounts.getAccount(creditcard_num).getCompanyName(), "Car", days, cost);

        transactions_history.add(trans);

        agency_vehicles.getVehicle(vin).cancelReservation();

        System.out.println("Vehicle has been returned");
	
	
} else if (agency_vehicles.getVehicle(vin) instanceof Trucks) {
	
	String creditcard_num = null;
    rates = agency_rates.getCarRates();
    
    String days = num_days_used + " days";

    cost = "$" + (agency_rates.calcActualCost(rates, num_days_used, num_miles_driven, agency_vehicles.getVehicle(vin).getReservation().insuranceSelected(), accounts.getAccount(agency_vehicles.getVehicle(vin).getReservation().getcreditCardNum()).primeCustomer()));

    Transaction trans = new Transaction(creditcard_num, accounts.getAccount(creditcard_num).getCompanyName(), "Car", days, cost);

    transactions_history.add(trans);

    agency_vehicles.getVehicle(vin).cancelReservation();

    
   
} return new String[] { "Vehicle has been returned" };
      } 

// Note that the rates to be used are retrieved from the VehicleRates object stored in the specific rented
// vehicle object, the daily insurance option is retrieved from the Reservation object of the rented
// vehicle, and whether they are a Prime customer is retrived from the Customer Account object vehicle
// associated with the Reservation object associated with the specific rented vehicle.

	// Vehicle Related Methods
public static String[ ] getAvailCars() { 
	
	
  agency_vehicles.reset();

while(agency_vehicles.hasNext()) {
	Vehicle veh = agency_vehicles.getNext();
	if(veh instanceof Car &&  !veh.isReserved()) {
	System.out.println(veh);
}
    }
	agency_vehicles.reset();
	
  return new String [] {};	
}

public static String[ ] getAvailSUVs() { 
	
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) {
		Vehicle veh = agency_vehicles.getNext();
		if(veh instanceof SUV && !veh.isReserved()) {
		System.out.println(veh);
	}
	    }
		agency_vehicles.reset();
		
		return new String[] {};
	
}
public static String[ ] getAvailTrucks() { 
	
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) {
		Vehicle veh = agency_vehicles.getNext();
		if(veh instanceof Trucks && !veh.isReserved()) {
		System.out.println(veh);
	}
	    }
		agency_vehicles.reset();
		
		return new String[] {};
	
}
public static String[ ] getAllVehicles() { 
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) {
		Vehicle veh = agency_vehicles.getNext();
		
		System.out.println(veh);
	
	    }
		agency_vehicles.reset();
		
		return new String[] {};
}

public static String[ ] makeReservation(ReservationDetails details) { 
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter Your VIN Number ");
	String VIN =input.nextLine();
	
	
	
	System.out.print("Enter Your Credit Card Number" );
	int creditCard_num =input.nextInt();
	
	System.out.print("Enter a Character for how many Days, Weeks or Months you would like ");
	char timeUnit= input.next().charAt(0);
	
	System.out.print("Enter an integer for the amount of Days, Weeks, or Months");
	int numUnit =input.nextInt();
	
	
	
	
	System.out.print("Would you like insurance?");
	boolean insurSelected =input.hasNextBoolean();
	
	ReservationDetails r1 = new ReservationDetails(VIN,creditCard_num, new TimeSpan (timeUnit,numUnit), insurSelected  );

	
	return new String[] { "Resevation Made! "};
}


public static String[ ] cancelReservation(String vin) { 
	
	Vehicles vehs= new Vehicles ();
	Scanner input = new Scanner(System.in);
	System.out.print("Enter your VIN Number");
	vehs.reset();
	String VIN= input.next();
	Vehicle veh = vehs.getVehicle(VIN);
	if (veh.isReserved()) {
		
	veh.cancelReservation();

	
	}	
	return new String[] { "Resevation Canceled!"};
}
public static String[ ] getReservation(String vin) { 
	
	Vehicles vehs= new Vehicles ();
	Scanner input = new Scanner(System.in);
	System.out.print("Enter your VIN Number");
	vin= input.nextLine();
	Vehicle veh = vehs.getVehicle(vin);
	if (veh.isReserved()) {
		
	veh.getReservation();

	
	}	
	
	return new String[] { veh.getReservation().toString() };

	
}
public static String[ ] getAllReservations() {
	
	
	Vehicle veh = null;
	while(agency_vehicles.hasNext()) {
	 veh =agency_vehicles.getNext();
	if (veh.isReserved()) {
		
	veh.getReservation();

	
	}	
	
	
}
	return new String[] {veh.getReservation().toString()};
}

// Customer Accounts Related Methods
	public static String[ ] addAccount(String creditcard, String company_name, boolean prime_cust) { 
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your Credit Card Number");
		creditcard = input.nextLine();
		
		System.out.print("Enter your company name");
		company_name= input.nextLine();
		
		System.out.print("Are you prime Customer");
		prime_cust =input.nextBoolean();
		
		Account a1 = new Account(creditcard,company_name,prime_cust);
		
		accounts.add(a1);
		
		return new String [] { "Account Added!" }; 
		
	}
	public static String[ ] getAccount(String creditcard_num) {
		
		accounts.getAccount(creditcard_num);
		
		return new String [] { "Account added!" };
	}
	public static String[ ] getAllAccounts() {
		
	    while (accounts.hasNext()) {
		
	    System.out.println(accounts.getNext());	
	}
	    return new String[] {};
	}
// transactions-related methods
	public static String[ ] getAllTransactions() { 
		
		while (transactions_history.hasNext()) {
			
			System.out.print(transactions_history.getNext());
			
		}
		
		return new String[] {};	
} 
	
	   public static boolean initialized(){
		
		return false;
		
	}


}


