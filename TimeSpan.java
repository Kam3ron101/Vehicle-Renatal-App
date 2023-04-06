public class TimeSpan {
	
	
	private char timeUnit; 
	private int numUnits;

	
	public TimeSpan(char timeUnit, int numUnits) {
		
		this.timeUnit=timeUnit;
		this.numUnits=numUnits;
		
	}
	
	public char getimeUnit() {
		
		return timeUnit;
	}
	
	public int getnumUnits() {
		
		return numUnits;
		
	}
	
		public String toString() {
			
			return "You have rented for "+numUnits+" "+timeUnit;
			
			
		}

}
