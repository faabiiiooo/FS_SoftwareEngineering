package lesson1_Calculator;

import java.util.ArrayList;

public class CalculatorModel {
	
	private String input;
	String[] inputs;
	
	
	public String computePlus(String input) throws NumberFormatException {
		
		this.input = input;
		this.inputs = this.input.split("\\+");  //Array mit den Zahlen links und rechts von +
		int result = 0;
		
		for(String s : this.inputs) {
			result += Integer.parseInt(s); //berechnen des Ergebnis
		}
		
		return ""+result;
		
	}
	
	
	

}
