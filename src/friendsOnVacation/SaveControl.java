package friendsOnVacation;

//Controller is a Listener

public class SaveControl implements java.awt.event.ActionListener {
	private Program model;
	private View view;

	//runs when a button is pressed
	public void actionPerformed(java.awt.event.ActionEvent e){
		try{
			//gets from text fields new expense details
			String name = view.getFriendName();
	        String type = view.getExpenseType();
	        String samount = view.getExpenseAmount();
	        
	        //checks whether name and amount fields are correct (not empty, amount numeric and positive)
	        view.errorMessage(model.checkError(name, samount));
	        
	        //if all text fields contain correct values saves data and updates tables and label values
	        if (model.checkError(name, samount) == 0){
	        	double amount = Double.parseDouble(samount);
				model.saveRecord(name, type, amount);					//saves expense data
				view.expensesToTable(model.getFriends());				//updates the first table (all records)
				view.setSumOfExpenses(model.sumOfExpenses());			//updates the label containing sum of all expenses
				view.setAverageOfExpenses(model.averageOfExpenses());	//updates the label containing average of all expenses
				view.setFriendsCount(model.getFriendsCount());			//updates the label containing count of friends
				view.friendsToTable(model.getFriends());				//updates the second table (each friends' sum of expenses)
				view.transactionsToTable(model.getTransactions());	   	//updates the third table (with transactions to be made)     	
	        }	        
		} catch(Exception x){ }		
	} //end of actionPerformed()

	public void addModel(Program m){ this.model = m; }
	public void addView(View v){ this.view = v; }

} //end of Controller class