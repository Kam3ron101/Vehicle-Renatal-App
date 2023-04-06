public class Vehicles {
    private VehicleNode head;
    private VehicleNode current;
    

    public Vehicles(){
        head = null;
        current = head;
    }
        
    public Vehicle getVehicle(String vin) {
    	
    	
        VehicleNode temp = head;
        boolean found = false;
        
        while(temp != null && !found) {
            if(temp.getValue().getVIN().equals(vin))
                found = true;
            else
                temp = temp.getNext();
            
            if (temp==null) {
            	
            System.out.print(" VINNotFoundException (VIN Not Found!)");	
            return null;
            }
        } 
        return temp.getValue();
        
    }
    
    public void add(Vehicle veh){

        VehicleNode node = new VehicleNode(veh, null);
        VehicleNode temp = head;
        if(temp == null)
            head = node;
        else {
            while(temp.getNext() != null)	{
				temp = temp.getNext();
			}
            temp.setNext(node);
        }
    }
    
    
    public void reset(){
        current = head;
    }
    
    public boolean hasNext(){        
        if(current != null)
            return true;
        else
            return false;
    }   
        
    public Vehicle getNext(){

        Vehicle veh = current.getValue();
        current = current.getNext();
        
        return veh;
    }
}




