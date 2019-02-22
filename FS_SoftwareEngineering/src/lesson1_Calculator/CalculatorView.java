package lesson1_Calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class CalculatorView extends Application {


	public static void main(String[] args) {
		launch(args);

	}
	
	//Variablen definitionen
	private Button btn, btnPlus, btnDel, btnEquals, btnZero;
	private CalculatorController controller;
	private TextField calcTxt;
	private String existOut;
	
	//In der Startmethode wird das komplette GUI aufgebaut. 
	
	public void start(Stage primaryStage) {
		
		this.controller = new CalculatorController();  //Instanzieren eines Controller Objekts
		this.controller.setCalcView(this);  //Beziehung zwischen Controller und View herstellen.
		this.existOut=""; //OutputString leer instanzieren.
		
		BorderPane rootPane = new BorderPane();  //Oberstes Layer ist ein BorderPane.
		GridPane calcPane = new GridPane();  //Buttons des Taschenrechners
		this.calcTxt = new TextField(); //Rechner ausgabe.
		
		calcTxt.setDisable(true);
		
		int btnNum = 1; //Variable zur Nummerierung der Buttons 1-9
		
		/*Die for Schlaufe beginnt im GridPane unten links, im Feld 3,0
		 * Generiert die Buttons 1-9 an der richtigen stelle und erstellt den onActionEvent.
		 */
		for(int row = 2; row >= 0; row--) {
			for(int col = 0; col < 3; col++) {
				this.btn = new Button((btnNum)+"");
				calcPane.add(this.btn, col, row);
				this.btn.setOnAction(controller::inputDigit);
				btnNum++;
			}
		}
		
		this.btnPlus = new Button("+");
		this.btnDel = new Button("C");  //Definieren der Operatoren
		this.btnEquals = new Button("=");
		this.btnZero = new Button("0");
		
		
		this.btnPlus.setOnAction(controller::inputDigit);
		this.btnEquals.setOnAction(controller::processEquals);
		this.btnZero.setOnAction(controller::inputDigit);
		
		this.btnDel.setOnAction(controller::clearTextField);
		
		this.btnDel.getStyleClass().add("calc-controls");
		this.btnEquals.setId("equals-button"); //Setzen einer eigenen CSS klasse, damit Blau färbung möglich
		this.btnPlus.getStyleClass().add("calc-controls");
		
				
		calcPane.add(this.btnPlus, 3, 0);
		calcPane.add(this.btnDel, 3, 1);
		calcPane.add(this.btnZero, 0, 3, 3, 3);  //Positionierung, span allowed bis zu col, row
		calcPane.add(this.btnEquals, 3, 2, 3, 3);
				
		
		rootPane.setCenter(calcPane);
		rootPane.setTop(calcTxt);
		
		//Automatische Grössenanpassung GridPane (siehe Java API)
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(25);
		calcPane.getColumnConstraints().addAll(cc, cc, cc, cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(25);
		calcPane.getRowConstraints().addAll(rc, rc, rc, rc);
		
		Scene scene = new Scene(rootPane);
		scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rechner");
		primaryStage.show();
		
	}
	
	public Button getBtn() {
		return this.btn;
	}
	
	public void setCalcTxt(String output) {
		
		/*Textfeld wird gesetzt, wenn output != null, wird String angefügt,
		 * wenn output = null, Textfeld wird geleert und existOut ebenfalls.
		 */
		
		if(output != null) {		
		this.existOut += output;
		this.calcTxt.setText(this.existOut);
		} else {
			this.calcTxt.setText("");
			this.existOut = "";
		}
		
	}
	
	public TextField getCalcTxt() {
		return this.calcTxt;
	}

}
