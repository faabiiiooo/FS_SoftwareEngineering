package lesson1_Layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layout extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	
	private Button alpha,beta,delta,gamma,left,right;
	private TextArea textArea;
	
	public void start(Stage primaryStage) {
	
	this.alpha = new Button("alpha");
	this.beta = new Button("beta");
	this.delta = new Button("delta");
	this.gamma = new Button("gamma");
	this.left = new Button("left");
	this.right = new Button("right");
	this.textArea = new TextArea();
	final Pane spacer = new Pane();
	SplitPane splitPane = new SplitPane();
		
	BorderPane rootPane = new BorderPane();
	VBox vBox = new VBox();
	HBox hBox = new HBox();
	
	hBox.setHgrow(spacer, Priority.ALWAYS);
    spacer.setMinSize(10, 1);
	
	vBox.getChildren().addAll(alpha,beta,splitPane,delta,gamma);
	hBox.getChildren().addAll(left,spacer,right);
	
	
	rootPane.setLeft(vBox);
	rootPane.setBottom(hBox);
	rootPane.setCenter(textArea);
	
	Scene scene = new Scene(rootPane);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Layout Exercise");
	primaryStage.show();
	
	
		
	}

}
