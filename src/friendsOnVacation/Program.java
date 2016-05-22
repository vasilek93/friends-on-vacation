package friendsOnVacation;

import java.util.ArrayList;
import java.util.List;
/*
* Class that hold main data processing methods, it saves expenses to list of friends,
* checks for errors in the input data, calculates average and sum of expenses, 
* finds transactions to be made.
*/

public class Program {	
	
	private List <Friend> friends = new ArrayList<Friend>();
	
	public void saveRecord(String tname, String ttype, double tamount) {		
		
		//checks whether in text field that stores type of expense user hadn't left default text
		if (ttype.equals("Type of expense")) 			 				
			ttype = "not defined"; //in that case set type to not defined
		
		Expense e = new Expense(ttype, tamount);
		try{			
			Friend f = new Friend(tname.substring(0, 1).toUpperCase() + tname.substring(1), e);	//the first letter of name is uppercased	
			
			//checks whether friend with this name already in list
			boolean in_list = false;										
			for (Friend fi : friends) {
				if (fi.getName().equals(f.getName()))
					in_list = true;
			}
			
			//add a new friend to the list of friends (if friend hasn't been in list yet)
			if( !in_list ){
					friends.add(f);															
			}
			
			//add a new expense to the friend that already has been in list
			else {
				for (Friend fi : friends) {
					if (fi.getName().equals(f.getName()))
						fi.setExpense(e);			
					}					
			}									
		}		
		/*catches an exception when tries to uppercase the first letter of empty name
		 * in fact, before saveRecord() method is called checkError() method, so
		 * empty name (also name starting with space or default expression) cannot appear here
		 */
		catch (Exception x){ return; }	
	}//end of saveRecord
	
	// Provides access to list that contains all expense data and the size of this list (number of friends in list)
	public List <Friend> getFriends(){ return friends; }
	public int getFriendsCount(){ return friends.size(); }
	
	//Method returns sum of all expenses that were made by all friends together
	public double sumOfExpenses(){
		double sum = 0;
		try {
			for (Friend fi : friends)
				sum += fi.sumOfExpenses();
			return sum;
		}
		catch (Exception x){ return 0;}		
	}// end of sumOfExpenses()
	
	//Method returns average value of all expenses that were made (this should be payed by every friend)
	public double averageOfExpenses(){
		double av = 0;
		try {		
			if (friends.size() != 0)
				av = sumOfExpenses()/ friends.size();
			return av;
		}
		catch (Exception x){ return 0; }
	} // end of averageOfExpenses()
	
	//Method returns list of transactions to be made 
	public List <Transaction> getTransactions(){		
		List <Transaction> transactions = new ArrayList<Transaction>();
		
		//calculates the credit of each friend - the difference between sum of his expenses and average amount of expense
		double tAmount = 0;		
		for (Friend fi : friends) {
			fi.setCredit (fi.sumOfExpenses() - averageOfExpenses());
		}
		
		/*loop finds a friend fi with negative credit (it means, that person has paid less than average
		 * and needs to give money to other friends.
		 * Then it finds a friend fj whose credit is positive (it means, that person has paid more than average
		 * and needs to receive money from other friends.
		 */		
		for (Friend fi : friends) {
			if (fi.getCredit() < 0)
				for (Friend fj : friends) {
					if ( (fj.getCredit() > 0) && (fi != fj)){
						
						// if fi doesn't have enough money to pay to fj, he pays all available money
						if ( Math.abs(fj.getCredit()) >= Math.abs(fi.getCredit()))  
							tAmount = fi.getCredit();
						
						// if fi has enough money to pay to fj, he pays all the sum that fj needs
						if ( Math.abs(fj.getCredit()) < Math.abs(fi.getCredit()))
							tAmount = -fj.getCredit();
						
						//transaction is made and added to the list of transactions
						Transaction t = new Transaction(fi.getName(), fj.getName(), tAmount);
						transactions.add(t);	
						
						//fj credit is corrrected ( as money was payed to him)
						fj.setCredit (fj.getCredit() + tAmount);
					}
					
					//fi credit is corrrected ( as money was payed by him)
					fi.setCredit(fi.getCredit() - tAmount); 
					
					//if fi has payed exactly average, iteration ends and next friend needs to be found
					if (fi.getCredit() == 0)
						break;
				}
		} // end of for loop
	return transactions;
	} // end of getTransations()

	//Method returns the number of error if it exists
	public int checkError(String name, String samount) {
		int error = 0;
		
		//checks whether friend's name doesn't start with space or default expression is left
		char a = name.charAt(0);
		if (a == ' ' || name.equals("Name of person"))
			error = 1;
		
		try{
			//checks whether amount is positive
			if (Double.parseDouble(samount) < 0)
				error = 2;
		}
		
		//checks whether amount is numeric
		catch (Exception x){
			error = 3;
		}		
		return error;
	} // end of checkErorr()
	
} //end of Model class
