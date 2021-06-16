package server;

public class Account {
	
	private String accountName;
	private double openingBalance;

	public Account(String accountName, double openingBalance) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
	}

	/* Pseudo code for moving money between accounts of the same user
	public moveMoney(String accountToMoveFrom, String accountToMoveTo, double openingBalance, double amountToMove, ) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
		if (accountToMoveFrom != null && String accountToMoveTo != null){
		long amountToMove in.readline
		if (currentBalance >= amountToMove)
		do {


		}
	}
	 */

	public String toString() {
		return (accountName + ": " + openingBalance);
	}

}
