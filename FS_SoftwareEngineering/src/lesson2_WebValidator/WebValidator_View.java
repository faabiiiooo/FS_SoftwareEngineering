package lesson2_WebValidator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WebValidator_View {
	
	private WebValidator_Model model;
	private Stage stage;
	protected TextField addressField, portField;
	protected Button connectBtn;
	
	protected WebValidator_View(Stage stage, WebValidator_Model model) {
		this.model = model;
		this.stage = stage;
		
		HBox hBox = new HBox();
		this.addressField = new TextField();
		this.portField = new TextField();
		hBox.getStyleClass().add("h-box");
		
		
		Label addressLabel = new Label("Address:");
		Label portLabel = new Label("Port:");
		
		hBox.getChildren().addAll(addressLabel, addressField, portLabel, portField);
		
		Scene scene = new Scene(hBox);
		scene.getStylesheets().add(getClass().getResource("WebValidator.css").toExternalForm());
		this.stage.setScene(scene);
		this.stage.setTitle("Web Address Validator");
		
	}
	
	public void start() {  //Shows gui when everything is readi in WebValidator start method.
		this.stage.show();
	}
	
	public void stop() {
		this.stage.hide();
	}

}
