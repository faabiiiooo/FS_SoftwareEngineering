package lesson1_Calculator;

import javafx.event.Event;
import javafx.scene.control.Button;

public class CalculatorController {
	
	private CalculatorView calcView;
	
	
	public void inputDigit(Event e) {
		
		//Zahl des gedruekten Buttons im TextFeld anzeigen.
		//Dazu wird das übergebene Event objekt ausgelesen.
		Button b = (Button) e.getSource();
		this.setTextField(b.getText());
		
	}
	
	public void processEquals(Event e) {  //wird beim Aufruf von = aufgerufen.
		String input = this.calcView.getCalcTxt().getText();
		CalculatorModel compute = new CalculatorModel();
		this.setTextField(null); //zurücksetzen des TextFelds
		try {
		this.setTextField(compute.computePlus(input)); //Setzen des Ergebniss welchen aus dem Model zurückgegeben wrid.
		} catch (NumberFormatException exception){
			this.setTextField("Error");
		}
	}
	
	public void clearTextField(Event e) {
		this.calcView.setCalcTxt(null);
	}
	
	private void setTextField(String output) {
		this.calcView.setCalcTxt(output);
	}
	
	public void setCalcView(CalculatorView calcView) {
		this.calcView = calcView;
		
	}

}
