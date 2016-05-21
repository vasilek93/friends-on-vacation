package friendsOnVacation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * ErrorMessage class that is designed to show error message boxes
 */
public class ErrorMessage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ErrorMessage(String error) {
		
		//general parameters of dialog box
		setResizable(false);
		setTitle("Error");
		setBounds(100, 100, 650, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//label that stores error message
		JLabel lblNewLabel = new JLabel(error);
		contentPanel.add(lblNewLabel);

		//OK button
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);	
		JButton okButton = new JButton("OK");
		
		//disposes when OK button is pressed
		okButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	} //end of ErrorMessage()

}//end of ErrorMessage class