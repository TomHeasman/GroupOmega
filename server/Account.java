package server;

public class Account {
	
	private String accountName;
	private long currentBalance;
	private long amountToMove;

	public Account(String accountName, long currentBalance) {
		this.accountName = accountName;
		this.currentBalance = currentBalance;
	}

	//Shall we have a different Class to handle the actual movement of money and we hand over the request?
	/* Pseudo code for moving money between accounts of the same user
	public moveMoneyToAnotherAccount(AccountToMoveTo, long amountToMove,) {
		this.accountName = accountName;
		this.currentBalance = currentBalance;

		if (accountToMoveFrom >= currentBalance && String accountToMoveTo != null){

		}
	}
	 */
	public String toString() {
		return (accountName + ": " + currentBalance);
	}

}
