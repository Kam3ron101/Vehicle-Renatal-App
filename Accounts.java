
// Collection of account objects 

public class Accounts {
	
	private Account[] accounts = new Account[100];
	int top=0;
	int current =-1;
	
	public Accounts() {}
		
		
	public void add(Account acct) { 
		accounts[top]=acct;
		top++;
		
		
	}
	public Account getAccount(String creditcard_num) { 
		
		for(int i=0; i<top; i++) {
			
		if	(creditcard_num==accounts[i].getCreditCardNum()) {
			
			return accounts[i];
		}
		}
		System.out.print("Account Does Not Exist!");
		return null;
	}
	
	  
	 public boolean hasNext(){
		 return current < top-1;
		 
	 }
	 
	 public Account getNext(){
		 current++;
		 return accounts[current];
	 }
	    
	public void reset() {
		
		current =-1;
		
	}
}
