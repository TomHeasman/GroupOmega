package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NewBankClientHandler extends Thread{
	
	private NewBank bank;
	private BufferedReader in;
	private PrintWriter out;
	
	
	public NewBankClientHandler(Socket s) throws IOException {
		bank = NewBank.getBank();
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);
	}
	
	public void run() {
		// keep getting requests from the client and processing them
		try {
			// ask for user name
			out.println("Enter Username");
			String userName = in.readLine();
			// ask for password
			out.println("Enter Password");
			String password = in.readLine();
			out.println("Checking Details...");
			// authenticate user and get customer ID token from bank for use in subsequent requests
			CustomerID customer = bank.checkLogInDetails(userName, password);
			// if the user is authenticated then get requests from the user and process them 
			if(customer != null) {
				//Line 37 does not actually print this. Can be commented out, and it will still print.
				out.println("Log In Successful. What do you want to do?");
				//Adding visual aid to users to provide options what they can do and how.
				out.println("1. View Your Accounts: Type == 1");
				out.println("2. Add New Account: Type == 'ADDNEWACCOUNT'");
				out.println("3. Move Money: Type == 'MOVE'");
				out.println("---------------------------------------------------------");
				out.println();
				while(true) {
					String request = in.readLine();
					//The line below is printed on the 'Server' side
					System.out.println("Request from " + customer.getKey());
					String response = bank.processRequest(customer, request);
					//Might need to add an iterator to segment out all accounts on different line
					out.println(response);
				}
			}
			else {
				out.println("Log In Failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}

}
