package server;

public class Account {
	
	private String accountName;
	private double openingBalance;

	public Account(String accountName, double openingBalance) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
	}

	/* Pseudo code for moving money between accounts of the same user
	public moveMoney(String accountToMoveTo, long amountToMove) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
		if (accountToMoveFrom != null && String accountToMoveTo != null){
		long amountToMove in.readline
		if (currentBalance >= amountToMove) {


		}
		else {
		out.println("Not enough found on your account!");
		}
	}
	 */

	public String toString() {
		return (accountName + ": " + openingBalance);
	}

}
