package friendsOnVacation;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
/*
* Class that represents graphical user interface (frame, tables, text fields, buttons).
*/

public class View {

	private JTable table;		//stores all records (the first table)
	private JTable table2;		//stores friends and sum of each friend's expenses (the second table)
	private JTable table3;		//stores transactions to be made
	
	DefaultTableModel tmodel = new DefaultTableModel(); 	//table model for the first table
	DefaultTableModel tmodel2 = new DefaultTableModel(); 	//table model for the second table
	DefaultTableModel tmodel3 = new DefaultTableModel(); 	//table model for the third table
	
	private JTextField name;	//place where user enters the name of person who made new expense
	private JTextField type;	//place where user enters the type of new expense
	private JTextField amount;	//place where user enters the amount of new expense	
	
	private JLabel friendCount;	//stores the number of friends
	private JLabel summa;		//stores sum of all expenses made by all friends together
	private JLabel average;		//stores average of expenses made
	
	JButton save = new JButton("Save"); //button for saving expense data from text fields
	JButton pdf = new JButton("Generate pdf document"); //button for saving data to pdf
	
	public View() {
		
		//general frame's parameters
		JFrame frmFriendsOnThe = new JFrame();
		frmFriendsOnThe.getContentPane().setFont(new Font("Arial", Font.BOLD, 11));
		frmFriendsOnThe.setTitle("Friends on the vacation");
		frmFriendsOnThe.setResizable(false);
		frmFriendsOnThe.setBounds(300, 300, 650, 600);
		frmFriendsOnThe.setLocation(200, 90);
		frmFriendsOnThe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		
		springLayout.putConstraint(SpringLayout.WEST, save, 539, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		frmFriendsOnThe.getContentPane().setLayout(springLayout);
				
		//table for storing all the expenses that were made
		table = new JTable(tmodel);
		tmodel.addColumn("Name");
		tmodel.addColumn("Type of Expense"); 
		tmodel.addColumn("Amount");		
		springLayout.putConstraint(SpringLayout.NORTH, table, 26, SpringLayout.NORTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 31, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 94, SpringLayout.NORTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 409, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		frmFriendsOnThe.getContentPane().add(table);
		
		//scrollpane for table that stores all expenses that were made
		JScrollPane scroll = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.EAST, pdf, 0, SpringLayout.EAST, scroll);
		springLayout.putConstraint(SpringLayout.WEST, scroll, 20, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		frmFriendsOnThe.getContentPane().add(scroll);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		//textField for storing name of person who made an expense (for an expense to be added)
		name = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, name, 16, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		name.setText("Name of person");
		frmFriendsOnThe.getContentPane().add(name);
		name.setColumns(10);
		name.setForeground(Color.GRAY);
		name.setFont(new Font("Tahoma", Font.ITALIC, 11));
				
		//textField for storing type of the expense (for an expense to be added)
		type = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, type, 0, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.WEST, type, 43, SpringLayout.EAST, name);
		springLayout.putConstraint(SpringLayout.EAST, type, -292, SpringLayout.EAST, frmFriendsOnThe.getContentPane());
		type.setText("Type of expense");
		frmFriendsOnThe.getContentPane().add(type);
		type.setColumns(10);
		type.setForeground(Color.GRAY);
		type.setFont(new Font("Tahoma", Font.ITALIC, 11));
				
		//textField for storing amount of the expense (for an expense to be added)
		amount = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, amount, 0, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.WEST, amount, 34, SpringLayout.EAST, type);
		springLayout.putConstraint(SpringLayout.EAST, amount, -35, SpringLayout.WEST, save);
		amount.setText("Amount of expense");
		frmFriendsOnThe.getContentPane().add(amount);
		amount.setColumns(10);
		amount.setForeground(Color.GRAY);
		amount.setFont(new Font("Tahoma", Font.ITALIC, 11));
				
		//table for storing all friends and sum of their expenses (each friend is stored only once, with the sum of his expenses) 
		table2 = new JTable(tmodel2);
		springLayout.putConstraint(SpringLayout.NORTH, table2, 0, SpringLayout.NORTH, frmFriendsOnThe.getContentPane());
		tmodel2.addColumn("Name");
		tmodel2.addColumn("Sum of Expenses");
		springLayout.putConstraint(SpringLayout.WEST, table2, 10, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table2, 581, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		frmFriendsOnThe.getContentPane().add(table2);
				
		//scrollpane for table storing each friends' expense sum
		JScrollPane scroll2 = new JScrollPane(table2);
		springLayout.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, scroll2);
		springLayout.putConstraint(SpringLayout.WEST, scroll2, 10, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scroll2, -26, SpringLayout.EAST, frmFriendsOnThe.getContentPane());
		frmFriendsOnThe.getContentPane().add(scroll2);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);														
				
		//label "Count of friends"
		JLabel labelCountOfFriends = new JLabel("Count of friends:");
		springLayout.putConstraint(SpringLayout.SOUTH, scroll, -6, SpringLayout.NORTH, labelCountOfFriends);
		springLayout.putConstraint(SpringLayout.NORTH, labelCountOfFriends, 150, SpringLayout.NORTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, labelCountOfFriends, 49, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		labelCountOfFriends.setFont(new Font("Arial", Font.PLAIN, 11));
		frmFriendsOnThe.getContentPane().add(labelCountOfFriends);							
				
		//label "Sum of expenses"
		JLabel lableSum = new JLabel("Sum of expenses:");
		springLayout.putConstraint(SpringLayout.NORTH, lableSum, 0, SpringLayout.NORTH, labelCountOfFriends);
		lableSum.setFont(new Font("Arial", Font.PLAIN, 11));
		frmFriendsOnThe.getContentPane().add(lableSum);
				
		//label "Average per Person"
		JLabel labelAverage = new JLabel("Average per person:");
		springLayout.putConstraint(SpringLayout.NORTH, labelAverage, 0, SpringLayout.NORTH, labelCountOfFriends);
		labelAverage.setFont(new Font("Arial", Font.PLAIN, 11));
		frmFriendsOnThe.getContentPane().add(labelAverage);
				
		//label "Expenses of each friend" above the second table
		JLabel labelExpensesOfEachFriend = new JLabel("Expenses of each friend:");
		springLayout.putConstraint(SpringLayout.EAST, name, 0, SpringLayout.EAST, labelExpensesOfEachFriend);
		springLayout.putConstraint(SpringLayout.EAST, labelExpensesOfEachFriend, -498, SpringLayout.EAST, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scroll2, 6, SpringLayout.SOUTH, labelExpensesOfEachFriend);
		springLayout.putConstraint(SpringLayout.SOUTH, labelExpensesOfEachFriend, -307, SpringLayout.SOUTH, frmFriendsOnThe.getContentPane());
		labelExpensesOfEachFriend.setFont(new Font("Arial", Font.BOLD, 11));
		frmFriendsOnThe.getContentPane().add(labelExpensesOfEachFriend);
				
		//scroll pane for table storing transactions to be made
		JScrollPane scroll3 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, pdf, 6, SpringLayout.SOUTH, scroll3);
		springLayout.putConstraint(SpringLayout.SOUTH, scroll3, -39, SpringLayout.SOUTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scroll3, 10, SpringLayout.WEST, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scroll3, 0, SpringLayout.EAST, scroll);
		frmFriendsOnThe.getContentPane().add(scroll3);
				
		//label "Transactions to be made" above the table with transactions
		JLabel labelTransactionsToBeMade = new JLabel("Transactions to be made:");
		springLayout.putConstraint(SpringLayout.SOUTH, labelTransactionsToBeMade, -157, SpringLayout.SOUTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scroll3, 6, SpringLayout.SOUTH, labelTransactionsToBeMade);
		springLayout.putConstraint(SpringLayout.EAST, labelTransactionsToBeMade, -498, SpringLayout.EAST, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scroll2, -26, SpringLayout.NORTH, labelTransactionsToBeMade);
		labelTransactionsToBeMade.setFont(new Font("Arial", Font.BOLD, 11));
		frmFriendsOnThe.getContentPane().add(labelTransactionsToBeMade);
				
		//table for storing transactions to be made
		table3 = new JTable(tmodel3);
		scroll3.setViewportView(table3);
		tmodel3.addColumn("From"); 
		tmodel3.addColumn("To");
		tmodel3.addColumn("Amount");
				
		//label "Add an expense" above the text fields for new expense details
		JLabel labelAddAnExpense = new JLabel("Add an expense:");
		springLayout.putConstraint(SpringLayout.SOUTH, labelAddAnExpense, -365, SpringLayout.SOUTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, name, 6, SpringLayout.SOUTH, labelAddAnExpense);
		labelAddAnExpense.setFont(new Font("Arial", Font.BOLD, 11));
		frmFriendsOnThe.getContentPane().add(labelAddAnExpense);
				
		/*label storing total count of friends (according to all expense records that were made - 
		* by counting distinct names)
		*/
		friendCount = new JLabel("0");
		springLayout.putConstraint(SpringLayout.WEST, lableSum, 45, SpringLayout.EAST, friendCount);
		springLayout.putConstraint(SpringLayout.NORTH, friendCount, 0, SpringLayout.NORTH, labelCountOfFriends);
		springLayout.putConstraint(SpringLayout.WEST, friendCount, 23, SpringLayout.EAST, labelCountOfFriends);
		friendCount.setFont(new Font("Arial", Font.PLAIN, 11));
		frmFriendsOnThe.getContentPane().add(friendCount);
				
		/*label storing total amount of expenses made (according to all expense records that were made 
		* - by summarizing amount of all expenses)
		*/
		summa = new JLabel("0");
		springLayout.putConstraint(SpringLayout.WEST, labelAverage, 77, SpringLayout.EAST, summa);
		springLayout.putConstraint(SpringLayout.NORTH, summa, 0, SpringLayout.NORTH, labelCountOfFriends);
		springLayout.putConstraint(SpringLayout.WEST, summa, 23, SpringLayout.EAST, lableSum);
		summa.setFont(new Font("Arial", Font.PLAIN, 11));
		frmFriendsOnThe.getContentPane().add(summa);
				
		/*label storing average amount of expenses made (according to all expense records that were made - 
		* by dividing sum of expenses by the count of friends)
		*/
		average = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, average, 0, SpringLayout.NORTH, labelCountOfFriends);
		springLayout.putConstraint(SpringLayout.WEST, average, 24, SpringLayout.EAST, labelAverage);
		average.setFont(new Font("Arial", Font.PLAIN, 11));
		frmFriendsOnThe.getContentPane().add(average);
		pdf.setFont(new Font("Arial", Font.BOLD, 11));
		frmFriendsOnThe.getContentPane().add(pdf);
		
		JLabel labelAllTheExpenses = new JLabel("All the expenses:");
		springLayout.putConstraint(SpringLayout.NORTH, scroll, 6, SpringLayout.SOUTH, labelAllTheExpenses);
		springLayout.putConstraint(SpringLayout.EAST, labelAddAnExpense, 0, SpringLayout.EAST, labelAllTheExpenses);
		springLayout.putConstraint(SpringLayout.SOUTH, labelAllTheExpenses, -549, SpringLayout.SOUTH, frmFriendsOnThe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table2, -8, SpringLayout.NORTH, labelAllTheExpenses);
		labelAllTheExpenses.setFont(new Font("Arial", Font.BOLD, 11));
		springLayout.putConstraint(SpringLayout.WEST, labelAllTheExpenses, 10, SpringLayout.WEST, table);
		frmFriendsOnThe.getContentPane().add(labelAllTheExpenses);
		springLayout.putConstraint(SpringLayout.SOUTH, save, -36, SpringLayout.NORTH, scroll2);
		springLayout.putConstraint(SpringLayout.EAST, save, -26, SpringLayout.EAST, frmFriendsOnThe.getContentPane());
		save.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmFriendsOnThe.getContentPane().add(save);
		
		JButton button = new JButton("?");
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, scroll);
		button.setFont(new Font("Arial", Font.BOLD, 11));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Help f = new Help();
				f.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, table);
		frmFriendsOnThe.getContentPane().add(button);
	
		frmFriendsOnThe.setVisible(true);	//show frame
							
	} //end of View()
	
	//provides access to text field values (name, type of expense and amount of expense)
	public String getFriendName() { return name.getText(); }
	public String getExpenseType() { return type.getText(); }
	public String getExpenseAmount() { return amount.getText(); }
	
	//provides opportunity to change label values (labels that store sum of expenses, average value and number of friends)
	public void setSumOfExpenses(double sum){ summa.setText(new DecimalFormat("#0.00").format(sum));}
	public void setAverageOfExpenses(double av){ average.setText(new DecimalFormat("#0.00").format(av));}
	public void setFriendsCount(int size){ friendCount.setText(size+"");}
	
	//empties table
	public void clearTable(DefaultTableModel pmodel){	
		while (pmodel.getRowCount() > 0){
			for (int i = 0; i < pmodel.getRowCount(); ++i){
				pmodel.removeRow(i);
		    }
		}
	} // end of clearTable()
	
	//writes all expenses (name, expense type and amount) to the first table
	public void expensesToTable (List <Friend> f) {
		clearTable(tmodel);
		for (Friend fi : f) {			
			tmodel.addRow(new Object[]{fi.getName(), fi.getExpenses().get(0).getType(), fi.getExpenses().get(0).getAmount()});
			}
	}//end of expensesToTable()
	
	//writes sum of each friend's expenses (name, expense sum) to the second table
	public void friendsToTable(List <Friend> f){
		clearTable(tmodel2);
		for (Friend fi : f) {
			tmodel2.addRow(new Object[]{fi.getName(), Double.toString(fi.sumOfExpenses())});   
		}					
	}//end of friendsToTable()
	
	//writes transactions (from, to and the amount) to the third table
	public void transactionsToTable(List <Transaction> t){
		clearTable(tmodel3);
		for (Transaction ti : t){
			tmodel3.addRow(new Object[]{ti.getFrom(), ti.getTo(), new DecimalFormat("#0.00").format(ti.getAmount())}); 
		}
	}//end of transactionsToTable()
	
	//shows error message depending on the number of error
	public void errorMessage(int error){
		String text = "";
		if (error == 0)
			return;
		if (error == 1)
			text = "The first character in name cannot be space! Name also cannot be equal to 'Name of person' expression!";
		if (error == 2)
			text = "Amount must be positive!";
		if (error == 3)
			text = "Amount must be numeric! Use . as decimal separator!";
		ErrorMessage message = new ErrorMessage(text);
		message.setVisible(true);			
	}//end of errorMessage()
	
	//empties text field and changes font if cursor is put there
	private void textFocused(JTextField field) {
		field.setText("");
		field.setForeground(Color.BLACK);
		field.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}//end of textFocused()
	
	//shows default expressions in text field if it there is no cursor in that field and it is empty
	private void textUnfocused(JTextField field) {
		if (field.getText().equals(""))
		{
			//gray italic font 
			field.setForeground(Color.GRAY);
			field.setFont(new Font("Tahoma", Font.ITALIC, 11));
			String text="";
			
			//if method is called for text field name
			if (field == name)
				text = "Name of person";
			
			//if method is called for text field type
			if (field == type)
				text = "Type of expense";
			
			//if method is called for text field amount
			if (field == amount)
				text = "Amount of expense";
			
			field.setText(text); //changes text field text
		}
	} //end of textUnfocused()
  	
	//action listener for button Save
	public void addControllerSave(ActionListener controller){
		save.addActionListener(controller); 
	} //end of addController()
	
	//action listener for button Save to PDF
		public void addControllerSavePdf(ActionListener controller){
			pdf.addActionListener(controller); 
		} //end of addController()
	
	//focus listener for text field name
	public void addController2(){		
		name.addFocusListener((new FocusAdapter() {			
			public void focusGained(FocusEvent e) { textFocused(name);}
			public void focusLost(FocusEvent e) { textUnfocused(name);}
		}));
	}//end of addController2()
	
	//focus listener for text field type
	public void addController3(){
		type.addFocusListener((new FocusAdapter() {			
			public void focusGained(FocusEvent e) { textFocused(type);}
			public void focusLost(FocusEvent e) { textUnfocused(type);}
		}));
	}//end of addController3()
	
	//focus listener for text field amount
	public void addController4(){
		amount.addFocusListener((new FocusAdapter() {			
			public void focusGained(FocusEvent e) { textFocused(amount);}
			public void focusLost(FocusEvent e) { textUnfocused(amount);}
		}));
	}//end of addController4()	
} //end of class View
