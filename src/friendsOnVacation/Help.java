package friendsOnVacation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
/*
* Short user manual (is opened when ? button is pressed)
*/

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Help() {
		setTitle("Help");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblThankYouFor = new JLabel("Thank You for using Friends on the vacation software.");
		lblThankYouFor.setFont(new Font("Arial", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblThankYouFor, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblThankYouFor, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblThankYouFor);
		
		JLabel lblHereIProvide = new JLabel("Here I provide short user manual.");
		lblHereIProvide.setFont(new Font("Arial", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblHereIProvide, 17, SpringLayout.SOUTH, lblThankYouFor);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHereIProvide, 0, SpringLayout.WEST, lblThankYouFor);
		contentPane.add(lblHereIProvide);
		
		JLabel lblToAdd = new JLabel("1. To add new expense that a friend made, type an expense details in text fields and press Save button.");
		lblToAdd.setFont(new Font("Arial", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblToAdd, 18, SpringLayout.SOUTH, lblHereIProvide);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblToAdd, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblToAdd);
		
		JLabel lblNameMust = new JLabel("1.1. Name must not be empty. You also cannot leave default expression in the name text field.");
		lblNameMust.setFont(new Font("Arial", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNameMust, 12, SpringLayout.SOUTH, lblToAdd);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNameMust, 22, SpringLayout.WEST, contentPane);
		contentPane.add(lblNameMust);
		
		JLabel lblExpenseType = new JLabel("1.2. Expense type is not mandatory field. If You leave there default expression, it will be called \"not defined\".");
		lblExpenseType.setFont(new Font("Arial", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblExpenseType, 10, SpringLayout.SOUTH, lblNameMust);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblExpenseType, 0, SpringLayout.WEST, lblNameMust);
		contentPane.add(lblExpenseType);
		
		JLabel lblExpenseAmount = new JLabel("1.3. Expense amount is mandatory field. It should be numeric and positive. Use . as decimal separator.");
		lblExpenseAmount.setFont(new Font("Arial", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblExpenseAmount, 10, SpringLayout.SOUTH, lblExpenseType);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblExpenseAmount, 0, SpringLayout.WEST, lblNameMust);
		contentPane.add(lblExpenseAmount);
		
		JLabel lblWhenYou = new JLabel("2. When You save data it appears in the first table. Please, remember that data You entered is not saved in a data base.");
		lblWhenYou.setFont(new Font("Arial", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWhenYou, 0, SpringLayout.WEST, lblThankYouFor);
		contentPane.add(lblWhenYou);
		
		JLabel lblTheSecond = new JLabel("3. The second table will show sum of each friend's expenses.");
		lblTheSecond.setFont(new Font("Arial", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTheSecond, 16, SpringLayout.SOUTH, lblWhenYou);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTheSecond, 0, SpringLayout.WEST, lblThankYouFor);
		contentPane.add(lblTheSecond);
		
		JLabel lblIfYou = new JLabel("* If You need to take in account friends who haven't made any expenses, type their names and enter amount 0.");
		lblIfYou.setFont(new Font("Arial", Font.ITALIC, 11));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIfYou, 0, SpringLayout.WEST, lblNameMust);
		contentPane.add(lblIfYou);
		
		JLabel lblTheThird = new JLabel("4. The third table willl display transactions to be made.");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTheThird, 0, SpringLayout.WEST, lblThankYouFor);
		lblTheThird.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(lblTheThird);
		
		JLabel lblIfYou_1 = new JLabel("** If You have several friends with the same names You should distinguish them (e.g. add digits 1, 2 etc. at the end of their names).");
		lblIfYou_1.setFont(new Font("Arial", Font.ITALIC, 11));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblIfYou, -6, SpringLayout.NORTH, lblIfYou_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWhenYou, 17, SpringLayout.SOUTH, lblIfYou_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIfYou_1, 202, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIfYou_1, 0, SpringLayout.WEST, lblNameMust);
		contentPane.add(lblIfYou_1);
		
		JLabel lblToSave = new JLabel("5. To save data to PDF document press button Save to PDF.");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTheThird, -17, SpringLayout.NORTH, lblToSave);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblToSave, 0, SpringLayout.WEST, lblThankYouFor);
		lblToSave.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(lblToSave);
		
		JLabel lblpdfCreatedWill = new JLabel("*PDF created will be saved to project directory.");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblpdfCreatedWill, 351, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblToSave, -10, SpringLayout.NORTH, lblpdfCreatedWill);
		lblpdfCreatedWill.setFont(new Font("Arial", Font.ITALIC, 11));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblpdfCreatedWill, 0, SpringLayout.WEST, lblNameMust);
		contentPane.add(lblpdfCreatedWill);
	}
}
