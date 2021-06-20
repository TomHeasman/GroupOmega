package server;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


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
		bhagy.addAccount(new Account("Saving", (long) 5750.0));
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
			//Changing 'case' parameter from word to number. Selection 1 == SHOWMYACCOUNTS
			if (request == "1") {
				return showMyAccounts(customer);
				//			case "2" : return createNewAccount(customer);
			}
			return "FAIL";
		}
		return "FAIL";
	}
	
	private String showMyAccounts(CustomerID customer) {
		return (customers.get(customer.getKey())).accountsToString();
	}

	/*  Pseudo code for creating new account
	private String createNewAccount(CustomerID customer) {
		out.println("Name of the new account:"):
		//read in name of the new account
		String newAccountName = in.readLine();
		//ReadInline has to be converted into ""
		customer.addAccount(newAccountName, 0.0)
		return (customers.get(customer.getKey())).accountsToString();
	}
	 */

	// function for adding compound interest to Primary amount p, over time period t,
	// at interest rate i, compounded n times
	public double addInterest(int p, int t, double r, int n) {
		double amount = p * Math.pow(1 + (r/t), n * t);
		return amount;
	}

	// psuedocode for adding daily compound interest
	/*
	public void givenUsingTimer_whenSchedulingDailyTask_thenCorrect() {
		TimerTask repeatedTask = new TimerTask() {
			public void run() {
				for (customer : customers) {
				if (accountType == "Savings" ) {
					// the add interest to the customer's savings account at the rate of 1.00001
					customer.updateBalance(	customer.addInterest(customer.currentBalance(), 1, 1.00001, 1))
				}
			}
		};
		Timer timer = new Timer("Timer");
		long delay = 1000L;
		long period = 1000L * 60L * 60L * 24L;
		timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	*/

}
