package friendsOnVacation;
/*
 * Class Transaction that represents transaction to be made.
 * Stores attributes From (name of friend who pays money), 
 * To (name of friend who receives money) and Amount of transaction.
 */

public class Transaction {
	private String from;		//name of friend who pays money
	private String to;			//name of friend who receives money)
	private double amount;		//amount of transaction
	
	//provides access to class attributes
	public String getFrom() { return from; }	
	public String getTo() {	return to; }
	public double getAmount() { return amount; }
	
	//provides opportunity to change values of attributes
	public void setFrom(String from) { this.from = from; }	
	public void setTo(String to) { this.to = to; }
	public void setAmount(double amount) { this.amount = amount; }	
	
	//constructor
	public Transaction(String from, String to, double amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

}