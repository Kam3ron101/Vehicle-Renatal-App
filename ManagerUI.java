import java.util.Scanner;

public class ManagerUI implements UserInterface {
	
	// no constructor needed, calls static methods of the SystemInterface
		// starts a �command loop� that repeatedly: (a) displays a menu of options, (b) gets the selected
		 // option from the user, and (c) executes the corresponding command.
		private boolean quit = false;
		public void start(Scanner input) {
		int selection;
		// command loop
		while(!quit) {
		displayMenu();
		selection = getSelection(input);
		try {
			execute(selection, input);
		} catch (VINNotFoundException e) {
			
			e.printStackTrace();
		}
		}
		 }
		 private void execute(int selection, Scanner input) throws VINNotFoundException {
		 int veh_type;
		
		String vin, creditcard_num; 
		String[] display_lines = null;
		 CurrentRates agency_rates;
		RentalDetails rental_details; ReservationDetails reserv_details;
		switch(selection) {
		
		// View and Update Rates
		case 1:
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 1 to Veiw Rates or Enter 2 to Update Rates");
		int num =in.nextInt();
		switch(num) {
		
		case 1: veh_type = getVehicleType(input);
			System.out.print("Enter 1 to Veiw Car Rates, Enter 2 to View SUV Rates and Enter 3 to view Truck Rates");
			int veh_rate_type = in.nextInt();
			switch (veh_rate_type) {
			case 1:display_lines = SystemInterface.getCarRates(); break;
			case 2: display_lines = SystemInterface.getSUVRates(); break;
			case 3: display_lines = SystemInterface.getTruckRates(); break;	
				
			} break;
			
			
		
		case 2: System.out.print("Enter 1 to uptdate car rates, Enter 2 to update SUV rates, Enter 3 to update Truck rates");
		int vehUpdate_rate_type =in.nextInt();
		switch(vehUpdate_rate_type) {
		
		
		case 1: 
		System.out.print("Enter the  Daily Car Rates");
		double daily_rate =in.nextDouble();
		
		System.out.print("Enter the Weekly Car Rates");
		double weekly_rate =in.nextDouble();
		
		System.out.print("Enter the Monthly Car Rates");
		double monthly_rate =in.nextDouble();
		
		System.out.print("Enter the Milage Charge for Car Rates");
		double mileage_chrg =in.nextDouble();
		
		System.out.print("Enter the Daily Insurance Rate for Car Rates");
		double daily_insur_rate =in.nextDouble();
		
		
		CarRates c1 = new CarRates(daily_rate,weekly_rate,monthly_rate,mileage_chrg,daily_insur_rate);
		
		display_lines = SystemInterface.updateCarRates(c1);
		
		
		case 2: 
			
			System.out.print("Enter the  Daily SUV Rates");
			double daily_rate2 =in.nextDouble();
			
			System.out.print("Enter the Weekly SUV Rates");
			double weekly_rate2 =in.nextDouble();
			
			System.out.print("Enter the Monthly SUV Rates");
			double monthly_rate2 =in.nextDouble();
			
			System.out.print("Enter the Milage Charge for SUV Rates");
			double mileage_chrg2 =in.nextDouble();
			
			System.out.print("Enter the Daily Insurance Rate for SUV Rates");
			double daily_insur_rate2 =in.nextDouble();
			
			
			SUVRates s1 = new SUVRates(daily_rate2,weekly_rate2,monthly_rate2,mileage_chrg2,daily_insur_rate2);
			
			display_lines = SystemInterface.updateCarRates(s1);	
			
		
		case 3: 
			System.out.print("Enter the Daily Truck rates");
			double daily_rate3 =in.nextDouble();
			
			System.out.print("Enter the Weekly Truck Rates");
			double weekly_rate3 =in.nextDouble();
			
			System.out.print("Enter the Monthly Truck Rates");
			double monthly_rate3 =in.nextDouble();
			
			System.out.print("Enter the Milage Charge for Truck Rates");
			double mileage_chrg3 =in.nextDouble();
			
			System.out.print("Enter the Daily Insurance Rate for Truck Rates");
			double daily_insur_rate3 =in.nextDouble();
			
			
			TruckRates t1 = new TruckRates(daily_rate3,weekly_rate3,monthly_rate3,mileage_chrg3,daily_insur_rate3);
			
			display_lines = SystemInterface.updateCarRates(t1);	
			
			
		}
		}
		displayResults(display_lines);
		break;
		// display all vehicles
		case 2: //veh_type = getVehicleType(input);
		display_lines = SystemInterface.getAllVehicles();
		displayResults(display_lines);
		break;
		// add accounts
		case 3: rental_details = getRentalDetails(input);
		creditcard_num = getCreditCardNum(input);
		String companyName= getCompanyName(input);
		boolean primeCustomer =getPrimeCustomer(input);
		display_lines = SystemInterface.addAccount(creditcard_num,companyName,primeCustomer);
		displayResults(display_lines);
		break;
		
		// view all reservations
		case 4: 
		display_lines = SystemInterface.getAllReservations();
		displayResults(display_lines);
		break;
		// view all accounts
		case 5: 
		display_lines = SystemInterface.getAllAccounts();
		displayResults(display_lines);
		break;
		// view transactions
		case 6:
		display_lines = SystemInterface.getAllTransactions();
		displayResults(display_lines);
		break;
		// quit
		case 7: quit = true;
		
		}
		}
		
		
		// ------- private methods
		private void displayMenu() {
			
			System.out.println(" MAIN MENU � MANAGER ");
			System.out.println(" 1 � View/Update Rates ");
			System.out.println(" 2 � View All Vehicles ");
			System.out.println(" 3 � Add Account ");
			System.out.println(" 4 � View All Reservations ");
			System.out.println(" 5 � View All Accounts ");
			System.out.println(" 6 � View Transactions ");
			System.out.println(" 7 - Quit ");
				
			
		}
		// displays the menu of options
		private int getSelection(Scanner input) { 
			Scanner in = new Scanner(System.in);
			int num = 0;
			do {
			System.out.print("Enter a number between 1 and 8: ");
		      num =in.nextInt();
			}
		   while (num <  1 || num  > 8);
				
				
				
			return num;
			
		}
		// prompts user for selection from menu (continues to prompt is selection < 1 or selection > 8)
		private String getVIN(Scanner input) {
			Scanner in = new Scanner(System.in);
			
			System.out.print("Enter Your VIN Number: ");
			String VIN = in.nextLine();
			
			
			return VIN;
			
		}
		// prompts user to enter VIN for a given vehicle (does not do any error checking on the input) { }
		private int getVehicleType(Scanner input) {
			Scanner in = new Scanner(System.in);
			int ans =0;
			do {
			System.out.print("Enter 1, 2 or 3 ");
			 ans = in.nextInt();
			}
			while (ans < 1 ||  ans > 3); 
				
				
				
			
			return ans;
			
		}
		// prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) { }
		private RentalDetails getRentalDetails(Scanner input) {
			Scanner in = new Scanner(System.in);
			
			
			System.out.print("Enter your Vehicle type 1 for Car 2 for SUV and 3 for Truck:");
			int vehicle_type =in.nextInt();
			
			System.out.print("Enter your Estimated number of miles");
			int estimatedNum_Miles = in.nextInt();
			
			System.out.print("Enter a character for the amount of Days, Weeks, or Months ");
			char timeUnit =in.next().charAt(0);
					
					
			System.out.print("Enter an integer for the amount of Days, Weeks, or Months");
			int numUnit =input.nextInt();
			
			System.out.print("Enter True or False for if you would like insurcance ");
			boolean insurSelected =in.hasNext();
			
			System.out.print("Enter True or False for if you would like be a prime customer ");
			boolean primeCustomer =in.hasNext();
			
			RentalDetails r1 = new RentalDetails(vehicle_type, new TimeSpan (timeUnit,numUnit), estimatedNum_Miles , insurSelected , primeCustomer);
			
		 SystemInterface.estimatedRentalCost(r1);
			
			
			return r1;
			
		}
		// prompts user to enter required information for an estimated rental cost (vehicle type, estimated
		// number of miles expected to be driven, rental period (number of days, weeks or months), and
		// insurance option, returning the result packaged as a RentalDetails object (to be passed in method
		// calls to the SystemInterface) { }
		private ReservationDetails getReservationDetails(Scanner input) {
			Scanner in = new Scanner(System.in);
			
			System.out.print("Enter Your VIN Number:");
			String VIN =in.nextLine();
			
			
			System.out.print("Enter Your Credit Card Number:");
			int creditCard_num = in.nextInt();
			
			
			System.out.print("Enter a character for the amount of Days, Weeks, or Months ");
			char timeUnit =in.next().charAt(0);
					
					
			System.out.print("Enter an integer for the amount of Days, Weeks, or Months");
			int numUnit =input.nextInt();
			
			System.out.print("Enter True or False for if you would like insurcance ");
			boolean insurSelected =in.hasNext();
			
			ReservationDetails r2 = new ReservationDetails(VIN,creditCard_num, new TimeSpan (timeUnit,numUnit), insurSelected);
			
		  SystemInterface.makeReservation(r2);
			
		   return r2;
		}
		// prompts user to enter required information for making a reservation (VIN of vehicle to reserve,
		// credit card num, rental period, and insurance option), returning the result packaged as a
		// ReservationDetails object (to be passed in method calls to the SystemInterface) { }
		private void displayResults(String[] lines) {
			
			for (int i=0; i< lines.length; i++ ) {
				
				System.out.print(lines[i]);
			}
			
			
		}
		// displays the array of strings passed, one string per screen line { }
		
		private String getCreditCardNum(Scanner input) {
			Scanner in = new Scanner(System.in);
			
			System.out.print("Enter Your Credit Card Number");
			String creditCard_num =in.nextLine();
					
			
			return creditCard_num;
		}
		
		private int getnum_day_used(Scanner input) {
			
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the amount of days used: ");
			int num_day_used= in.nextInt();
			
			return num_day_used;
		}
		
		private int getnum_miles_driven(Scanner input) {
			
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the amount of miles driven: ");
			int num_miles_driven= in.nextInt();
			
			return num_miles_driven;
		}
		
		private String getCompanyName(Scanner input) {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Your Company Name: ");
			String companyName=in.nextLine();
			
			return companyName;
			
		}
		
		private boolean getPrimeCustomer(Scanner input) {
			Scanner in = new Scanner(System.in);
			System.out.print("Are You a prime customer? (Enter True or False) ");
			boolean primeCustomer=in.hasNext();
			
			
			return primeCustomer;
		}

}
