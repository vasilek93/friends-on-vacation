package friendsOnVacation;
import java.util.ArrayList;
import java.util.List;
/*
 * class Friend that represents friends who have gone on the vacation. 
 * Class stores his/her name, list of expenses made by him/her,
 * method for calculating sum of friend's expenses and credit attribute 
 * that is used to store difference between sum of his/her expenses and average value of expenses.
 */
public class Friend {

	private String name;											//name of friend
	private List <Expense> expenses = new ArrayList <Expense>();	//list of expenses made by friend
	private double credit = 0;										//difference between sum of friend's expenses and average value
	
	//provides access to class attributes
	public String getName() { return name; }	
	public double getCredit() {	return credit; }
	public List <Expense> getExpenses() { return expenses; }
	
	//provides opportunity to change attribute values
	public void setName(String name) { this.name = name; }
	public void setCredit(double credit) { this.credit = credit; }	
	public void setExpense(Expense e) { expenses.add(e); }
	
	//constructor with parameters	
	public Friend(String name, Expense e) {
		this.name = name;
		expenses.add(e);
	}//end of Friend()

	//calculates sum of friend'd expenses
	public double sumOfExpenses(){
		double summa = 0;
		try{
			for (Expense ei : expenses)
				summa += ei.getAmount();
			return summa;
		}
		catch (Exception x){ return 0; }
	} // end of sumOfExpenses()

}//end of class Friend
