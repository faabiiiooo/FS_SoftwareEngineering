package lesson2_WebValidator;

import javafx.stage.Stage;

public class WebValidator_Controller {
	
	/*
	 *  getting Relationships between Model, controller, View done. 
	 */
	
	private final WebValidator_View view;
	private final WebValidator_Model model;
	private final Stage stage;
	
	protected WebValidator_Controller(Stage stage, WebValidator_View view, 
			WebValidator_Model model) {
		
		this.stage = stage;
		this.view = view;
		this.model = model;
		
		this.view.addressField.textProperty().addListener((observable, oldValue, newValue) -> 
		validateAddress(newValue)); //Adding Listener to Address Field
		
		this.view.portField.textProperty().addListener((observable, oldValue, newValue) -> 
		validatePort(newValue)); //Adding Listener to port Field
		
	}
	
	private void validateAddress(String newValue) {
		String[] address = newValue.split("\\.");  
		boolean valid = false;
		
		/*
		 * Checking if valid value has been entered. First for IPv4
		 */
		
		if(address.length == 4) {
			valid = true;
			for(String s : address) {
				try {
					if(Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0)
						valid = false;
					//System.out.println("try"+valid);
				} catch (NumberFormatException nfe) {
					valid = false;
					//System.out.println("catch"+valid);
				}
			}
			
		}
		
		//System.out.println(valid);
		
		//Checking for domain inputs
			
		if(!valid) {
			if(address.length >= 2) {
				valid = true;
				for(String s : address) {
					if(s.length() < 2) valid =false;
				}
			}
		}
		
		//setting text color based on if statements above.
		
		if(valid) 
			this.view.addressField.setStyle("-fx-text-inner-color:green;");
		else 
			this.view.addressField.setStyle("-fx-text-inner-color:red;");
			
			
	}
	
	private void validatePort(String newValue) {
		int port = -1;
		try {
		port = Integer.parseInt(newValue);  //Extracting port number out of string. 
		} catch (NumberFormatException e){
			this.view.portField.setStyle("-fx-text-inner-color:red;"); 
		}
		
		if(port > 0 && port <= 65535) { //Checking if Portnumber is valid and setting font color.
			this.view.portField.setStyle("-fx-text-inner-color:green;");
		} else {
			this.view.portField.setStyle("-fx-text-inner-color:red;");
			
		}
		
	}

}
