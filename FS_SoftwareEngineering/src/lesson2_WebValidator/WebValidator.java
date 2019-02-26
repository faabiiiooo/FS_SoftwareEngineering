package lesson2_WebValidator;

import javafx.application.Application;
import javafx.stage.Stage;

public class WebValidator extends Application {
	
	private WebValidator_View view;
	private WebValidator_Model model;
	private WebValidator_Controller controller;

	public static void main(String[] args) { //Startpoint of application
		launch(args);

	}
	
	public void start(Stage primaryStage) {
		this.model = new WebValidator_Model();
		this.view = new WebValidator_View(primaryStage, this.model);
		this.controller = new WebValidator_Controller(primaryStage, this.view, this.model); //getting gui ready befor show it.
		
		this.view.start();
	}
		

}
