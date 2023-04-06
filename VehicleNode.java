public class VehicleNode {
	
	
	private Vehicle vehicle;
	private VehicleNode next;
	
	

	public VehicleNode(Vehicle veh, VehicleNode next) {
		this.vehicle=veh;
		this.next=next;
		}
	
	public Vehicle getValue() { 
		return vehicle;
	}
	
	public VehicleNode getNext()  {
		
		return next;
		
	}
	
	public void setNext(VehicleNode next) {
		
		this.next=next;
		
	}
	
		
		
		
		

	
}


