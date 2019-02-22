package lesson1_Dice;

import java.util.Random;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RollDice extends Application {

	public static void main(String[] args) {
		
		launch(args);

	}
	
	Button dice1 = new Button();
	Button dice2 = new Button();
	
	public void start(Stage primaryStage) {
		
		GridPane rootPane = new GridPane();
		
		
		rootPane.setConstraints(dice1,0,0);
		rootPane.setConstraints(dice2,1,0);
		
		rootPane.getChildren().addAll(dice1,dice2);
		
		dice1.setOnAction(this::processRollDice1);
		dice2.setOnAction(this::processRollDice2);
		
		dice1.setPrefSize(120, 120);
		dice2.setPrefSize(120, 120);
		
		Scene scene = new Scene(rootPane);
		scene.getStylesheets().add(getClass().getResource("RollDiceCss.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Roll-the-Dice");
		primaryStage.show();
		
	}
	
	private void processRollDice1(Event e) {
		
		Random rand = new Random();
		int random = rand.nextInt(6)+1;
		this.dice1.setText(random+"");
		
	}
	
	private void processRollDice2(Event e) {
		
		Random rand = new Random();
		int random = rand.nextInt(6)+1;
		this.dice2.setText(random+"");
	}

}
