import java.util.Scanner;

public class AgencyRentalProgram {
	
	public static void main(String[ ] args) {
		// Provide Hard-coded Current Agency Rates
		CurrentRates agency_rates = new CurrentRates(new CarRates(22.95,159.95,514.95,0.15,14.95),
		 new SUVRates(22.95,189.95,679.95,0.15,14.95),
		new TruckRates(33.95,224.95,787.95,0.26,21.95));
		// Create an Initially Empty Vehicles Collection, and Populate
		Vehicles agency_vehicles = new Vehicles();
		populate(agency_vehicles); // supporting private static method (to be added)
		// Create Initially Empty Accounts and Transactions Objects
		Accounts accounts = new Accounts();
		Transactions transactions = new Transactions();
		// Establish User Interface
		Scanner input = new Scanner(System.in);
		UserInterface ui;
		boolean quit = false;
		// Create Requested UI and Begin Execution
		while(!quit) { // (allows switching between Employee and Manager user interfaces while running)
		ui = getUI(input);
		if(ui == null)
		quit = true;
		else {
		// Init System Interface with Agency Data (if not already initialized)
		if(!SystemInterface.initialized())
		 SystemInterface.initSystem(agency_rates, agency_vehicles, accounts, transactions);
		// Start User Interface
		ui.start(input);
		}
		}
		}
		public static UserInterface getUI(Scanner input) {
		boolean valid_selection = false;
		while(!valid_selection) {
		System.out.print("1 � Employee, 2 � Manager, 3 � quit:");
		int selection = input.nextInt();
		if(selection == 1) {
		
		valid_selection = true;
		return new EmployeeUI();
		}
		else
		if(selection == 2) {
		
		valid_selection = true;
		return new ManagerUI();
		}
		else
		if(selection == 3) {
		
		valid_selection = true;
		return null;
		}
		else
		System.out.println("Invalid selection � Please Reenter");
		}
		return null;
		}
		
		public static Vehicles populate(Vehicles v1) {
			
			TimeSpan t1 = new TimeSpan('d', 1);
			Reservation r1 = new Reservation ("4578 4562 5643 9173", t1, true);
			
			Car C1 = new Car("Chevrolet Camaro - (Car)",30, "KH4GM4564GO", null,2);
			Car C2 = new Car("Ford Fusion - 2018 (Car)",34, "AB4EG5689GM", null,4);
			Car C3 = new Car("Ford Fusion Hybrid - (Car)",32, "KV4EG3245RW", null,4);
			Car C4 = new Car("Chevrolet Impala - 2019 (Car)",30, "RK3MB4366YH", null,4);
			
			SUV S1 = new SUV("Honda Odyssey -  (SUV)",28, "VN9RF2635TD", null,7, 6);
			SUV S2 = new SUV("Dodge Caravan -  (SUV)",25, "QK3FT4273ME", null,5, 4);
			SUV S3 = new SUV("Ford Expedition - (SUV)",20, "JK2HT8264HY", null,5, 3);
			
			Trucks T1 = new Trucks("Ten-Foot - (Truck)",12, "EJ5KU2437BC", null, 2810);
			Trucks T2 = new Trucks("Eighteen-Foot - (Truck)",10, "KG4MD5472RK", null, 5930);
			Trucks T3 = new Trucks("Twenty-Four-Foot - (Truck)",8, "EB2WR3082QB", null, 6500);
			Trucks T4 = new Trucks("Twenty-Four-Foot - (Truck)",8, "TV3GH4390EK", null, 6500);
			
			v1.add(C1);
			v1.add(C2);
			v1.add(C3);
			v1.add(C4);
			
			v1.add(S1);
			v1.add(S2);
			v1.add(S3);
			
			v1.add(T1);
			v1.add(T2);
			v1.add(T3);
			v1.add(T4);
			
			v1.reset();
			
			return v1;
			
		}
		
		
		}
	


