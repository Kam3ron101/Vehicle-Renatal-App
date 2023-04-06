public class Transactions {

	private Transaction[]  transactions = new Transaction[100];
	int top=0;
	int current =-1;
	
	
	
	
	
	public void add(Transaction tran) { 
		transactions[top]=tran;
		top++;
			
	}
	
	 public void reset(){
		 current= -1;
		 
	 }
	  
	 public boolean hasNext(){
		
		 return current < top-1;
	 }
	 
	 public Transaction getNext(){
		 current++;
		 return transactions[current];
	 }
}
