package friendsOnVacation;
/*
 * Class Expense that represents one expense that was made.
 * Attributes store type and amount of expense.
 */

public class Expense {	
	
	private String type;		//type of expense
	private double amount;		//amount of expense
	
	//provides opportunity to change attribute values
	public void setType(String type) { this.type = type; }	
	public void setAmount(double amount) { this.amount = amount; }	
	
	//provides access to class attributes
	public String getType() { return type; }	
	public double getAmount() {	return amount; }	
	
	//constructor
	public Expense(String type , double amount) {
		this.type = type;
		this.amount = amount;
	}
}