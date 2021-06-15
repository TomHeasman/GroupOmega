package server;

import java.util.HashMap;

public class NewBank {
	
	private static final NewBank bank = new NewBank();
	private HashMap<String,Customer> customers;
	private HashMap<String,Customer> passwords;
	
	private NewBank() {
		customers = new HashMap<>();
		passwords = new HashMap<>();
		addTestData();
	}

	//Casted all amount to long to avoid rounding up.
	private void addTestData() {
		Customer bhagy = new Customer();
		bhagy.addAccount(new Account("Main", (long) 1000.0));
		customers.put("Bhagy", bhagy);
		passwords.put("Password1", bhagy);
		
		Customer christina = new Customer();
		christina.addAccount(new Account("Savings", (long) 1500.0));
		customers.put("Christina", christina);
		passwords.put("Password2", christina);
		
		Customer john = new Customer();
		john.addAccount(new Account("Checking", (long) 250.0));
		customers.put("John", john);
		passwords.put("Password3", john);
	}
	
	public static NewBank getBank() {
		return bank;
	}
	
	public synchronized CustomerID checkLogInDetails(String userName, String password) {
		//Password check is implemented
		if(customers.containsKey(userName) && (passwords.containsKey(password))) {
			return new CustomerID(userName);
		}
		return null;
	}

	// commands from the NewBank customer are processed in this method
	public synchronized String processRequest(CustomerID customer, String request) {
		if(customers.containsKey(customer.getKey())) {
			switch(request) {
				//Changing 'case' parameter from word to number. Selection 1 == SHOWMYACCOUNTS
			case "1" : return showMyAccounts(customer);
			default : return "FAIL";
			}
		}
		return "FAIL";
	}
	
	private String showMyAccounts(CustomerID customer) {
		return (customers.get(customer.getKey())).accountsToString();
	}

}
