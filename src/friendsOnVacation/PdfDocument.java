package friendsOnVacation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/*
* Class that represents PDF documents and contains the methods for adding content to PDF document.
*/

public class PdfDocument {
	
	private Document document = new Document();
	private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");	
	private String FILE = "friends.pdf";
	private Font fontbold = FontFactory.getFont("Times-Roman", 12, Font.BOLD);
	
	//created pdf document at the location defined by FILE variable
	public void CreatePdfDocument(){		
		try{
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
		} 
		catch (FileNotFoundException e1) { }
		catch (DocumentException e1) { }     
	} //end of CreatePdfDocument()
	
	//adds all content to created pdf document
	public void addContent(List <Friend> friends, List <Transaction> transactions) throws DocumentException{
		document.open();
		addHeader();					//date and header
		addAllExpenses(friends);		//list with all expenses made (friend and all expenses he made)
		addSumOfExpenses(friends);		//table with sum of each friend's expenses
		addTransactions(transactions);	//table with transactions to be made
		document.close();	//without closing pdf is corrupted
	} //end of addContent
	
	//adds date and header to document
	public void addHeader() throws DocumentException{		
		Date date = new Date();
	    Paragraph p = new Paragraph("Friends on the vacation, generated: " + dateFormat.format(date), fontbold);
	    p.setAlignment(Element.ALIGN_CENTER);
	    p.add(new Chunk("\n"));
	    p.add("Expenses made and transactions to be made");	 	    
	    p.add(new Chunk("\n\n\n"));
	    document.add(p);
	} // end of addHeader()	
	
	//adds list of all friends and all expenses that were made by each friend
	public void addAllExpenses(List <Friend> friends) throws DocumentException {		
	    
		//header of the section
		Paragraph p = new Paragraph("Expenses made:", fontbold);
	    p.setAlignment(Element.ALIGN_LEFT);    
	    p.add(new Chunk("\n\n"));
	    document.add(p);
	    
	    //retrieving all friends from list friends
	    p = new Paragraph();	    	    
	    for (Friend fi: friends){
	    	p.add("Name: "+ fi.getName());
	    	p.add(new Chunk("\n"));
	    	for (Expense ei : fi.getExpenses()){
	    		p.setTabSettings(new TabSettings(60f));
	            p.add(Chunk.TABBING);
	    		p.add("Expense Type: " + ei.getType() + "		");
	    		p.setTabSettings(new TabSettings(60f));
	            p.add(Chunk.TABBING);
	    		p.add("Expense Amount: " + ei.getAmount()+ "		");
	    		p.add(new Chunk("\n"));
	    	}	
	    p.add(new Chunk("\n"));	
	    }
	p.add(new Chunk("\n\n"));
	document.add(p);
	} // end of addAllExpenses()

	//adds table with friends names and sum of each friend'd expenses
	private void addSumOfExpenses(List <Friend> friends) throws DocumentException {
		
		//header of the section
		Paragraph p = new Paragraph("Each friend's sum of expense:", fontbold);
		p.add(new Chunk("\n\n"));
		document.add(p);
		
		PdfPTable table = new PdfPTable(2);

	    //table header Name		Sum of expenses
		PdfPCell c1 = new PdfPCell(new Phrase("Name"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Sum of expenses"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    table.setHeaderRows(1);
	    
	    //friend's name and sum of his expenses
	    for (Friend fi: friends){
	    	table.addCell(new Phrase(fi.getName()));
	    	table.addCell(new Phrase(Double.toString(fi.sumOfExpenses())));
	    }
	    document.add(table);
	  }//end of addSumOfExpenses()
	
	//adds table with transactions to be made
	private void addTransactions(List <Transaction> transactions) throws DocumentException {
		
		//header of the section
		Paragraph p = new Paragraph("\n\n" + "Transactions to be made:", fontbold);
		p.add(new Chunk("\n\n"));
		document.add(p);
	    
		PdfPTable table = new PdfPTable(3);

	    //table header
		PdfPCell c1 = new PdfPCell(new Phrase("From"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("To"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Amount"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    table.setHeaderRows(1);
	    
	    //transaction details (From To Amount)
	    for (Transaction ti: transactions){
	    	table.addCell(new Phrase(ti.getFrom()));
	    	table.addCell(new Phrase(ti.getTo()));
	    	table.addCell(new Phrase(Double.toString(ti.getAmount())));
	    }
	    document.add(table);
	  } // end of addTransactions()
	
} // end of PdfDocument class
