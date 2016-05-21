package friendsOnVacation;
public class Main{

	public static void main(String[] args){
				Program myModel 	= new Program();
				PdfDocument myPdf 	= new PdfDocument();
				View myView 	= new View();
				
				//controller for button Save
				SaveControl myController = new SaveControl();				
				myController.addModel(myModel);
				myController.addView(myView);				
				myView.addControllerSave(myController);
				
				//controller for button Save PDF
				PdfControl myControllerPDF = new PdfControl();				
				myControllerPDF.addDocument(myPdf);
				myControllerPDF.addModel(myModel);				
				myView.addControllerSavePdf(myControllerPDF);
				
				//controllers for text fields
				myView.addController2(); //for name
				myView.addController3(); // for expense type
				myView.addController4(); // for expense amount
	} //end of main()

} //end of Main class