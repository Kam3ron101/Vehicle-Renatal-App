public class Transaction {

	private String creditcard_num;
	private String company_name;
	private String vehicle_type; // car, SUV or Truck
	private String rental_period; // days, week, months
	private String rental_cost;

	
	public Transaction(String creditcard_num, String company_name, String vehicle_type, String rental_period, String rental_cost) {
		
		this.creditcard_num = creditcard_num;
		this.company_name =company_name;
		this.vehicle_type = vehicle_type;
		this.rental_period = rental_period;
		this.rental_cost = rental_cost;
		
	}
	
	public String toString() {
		
		return " Credit Card Number: "+creditcard_num+ " Company Name: "+company_name+ " Vehicle Type: "+vehicle_type+ " Rental Period " +rental_period+ " Rental Cost: "+rental_cost;	
				}
	
	}

