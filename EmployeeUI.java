import java.util.Scanner;

public class EmployeeUI implements UserInterface {
	
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
			 private void execute(int selection, Scanner input) throws VINNotFoundException  {
			 int veh_type;
			
			String vin, creditcard_num; 
			String[] display_lines = null;
			RentalDetails rental_details; ReservationDetails reserv_details;
			switch(selection) {
			// display rental rates
			case 1: veh_type = getVehicleType(input);
			switch(veh_type) {
			
			 case 1: display_lines = SystemInterface.getCarRates(); break;
			 case 2: display_lines = SystemInterface.getSUVRates(); break;
			 case 3: display_lines = SystemInterface.getTruckRates(); break;
			}
			displayResults(display_lines);
			break;
			// display available vehicles
			case 2: veh_type = getVehicleType(input);
			switch(veh_type) {
			 case 1: display_lines = SystemInterface.getAvailCars(); break;
			 case 2: display_lines = SystemInterface.getAvailSUVs(); break;
			 case 3: display_lines = SystemInterface.getAvailTrucks(); break;
			}
			displayResults(display_lines);
			break;
			// display estimated rental cost
			case 3: rental_details = getRentalDetails(input);
			display_lines = SystemInterface.estimatedRentalCost(rental_details);
			displayResults(display_lines);
			break;
			
			// make a reservation
			case 4: reserv_details = getReservationDetails(input);
			display_lines = SystemInterface.makeReservation(reserv_details);
			displayResults(display_lines);
			break;
			// cancel a reservation
			case 5: vin = getVIN(input);
			display_lines = SystemInterface.cancelReservation(vin);
			displayResults(display_lines);
			break;
			// view corporate account (and company reservations)
			case 6: creditcard_num = getCreditCardNum(input);
			display_lines = SystemInterface.getAccount(creditcard_num);
			displayResults(display_lines);
			break;
			// process returned vehicle
			case 7: creditcard_num = getCreditCardNum(input);
			vin = getVIN(input);
			int num_day_used = getnum_day_used(input);
			int num_miles_driven= getnum_miles_driven(input);
			display_lines = SystemInterface.processReturnedVehicle(vin, num_day_used ,num_miles_driven);
			displayResults(display_lines);
			break;
			// quit program
			case 8: quit = true;
			}
			}
			
			// ------- private methods
			private void displayMenu() {
				
				System.out.println("MAIN MENU � EMPLOYEE ");
				System.out.println(" 1 � View Current Rates ");
				System.out.println(" 2 � View Available Vehicles ");
				System.out.println(" 3 � Calc Estimated Rental Cost ");
				System.out.println(" 4 � Make a Reservation ");
				System.out.println(" 5 � - Cancel Reservation ");
				System.out.println(" 6 � View Corporate Account ");
				System.out.println(" 7 - Process Returned Vehicle ");
				System.out.println(" 8 - Quit ");
					
				
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
				System.out.print("Enter 1 for Car  2  for SUV or 3 for Truck ");
				 ans = in.nextInt();
				}
				while (ans < 1 ||  ans > 3); 
					
					
					
				
				return ans;
				
			}
			// prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) { }
			private RentalDetails getRentalDetails(Scanner input) {
				Scanner in = new Scanner(System.in);
				
				
				System.out.print("Enter your Vehicle type 1 for Car 2 for SUV 3 for Truck");
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
			
}
