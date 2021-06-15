package server;

public class Account {
	
	private String accountName;
	private long currentBalance;

	public Account(String accountName, long currentBalance) {
		this.accountName = accountName;
		this.currentBalance = currentBalance;
	}

	/* Pseudo code for moving money between accounts of the same user
	public moveMoneyToAnotherAccount(AccountToMoveTo, long amountToMove,) {
		this.accountName = accountName;
		this.currentBalance = currentBalance;
		if (accountToMoveFrom != null && String accountToMoveTo != null){

		}
	}
	 */
	public String toString() {
		return (accountName + ": " + currentBalance);
	}

}
