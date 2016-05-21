package friendsOnVacation;

import java.util.List;

public class PdfControl implements java.awt.event.ActionListener {
	private PdfDocument document;
	private Program model;

	//runs when a button Save to PDF is pressed
	public void actionPerformed(java.awt.event.ActionEvent e){
		try{
			
			//gets friends and transactions lists
			List <Friend> f = model.getFriends();
			List <Transaction> t = model.getTransactions();
			
			//created PDF and adds content to it
			document.CreatePdfDocument();
			document.addContent(f, t);				
		
		} catch (Exception x){ }
	} //end of actionPerformed()

	public void addDocument(PdfDocument d){ this.document = d; }
	public void addModel(Program m){ this.model = m; }

} //end of Controller class