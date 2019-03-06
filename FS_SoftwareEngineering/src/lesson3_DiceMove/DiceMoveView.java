package lesson3_DiceMove;



import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DiceMoveView extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	
	public void start(Stage primaryStage) {
		
		Rectangle dice = new Rectangle(0,0,50,50);
		dice.setStroke(Color.BLUE);
		dice.setStrokeWidth(4);
		dice.setFill(Color.GREEN);
		
		Group objects = new Group();
		objects.getChildren().addAll(dice);
		
		//Pfad definieren		
		PathElement start = new MoveTo(25,25);
		PathElement upRight = new LineTo(375,25);
		PathElement dwnRight = new LineTo(375,375);
		PathElement dwnLeft = new LineTo(25,375);
		PathElement bkStart = new LineTo(25,25);
		
		Path path = new Path();
		path.getElements().addAll(start,upRight,dwnRight,dwnLeft,bkStart);
		PathTransition move = new PathTransition(Duration.millis(4000),path,dice);
		
		//Farbänderung definieren		
		FillTransition fill = new FillTransition(Duration.millis(2000));
		fill.setToValue(Color.RED);
		fill.setAutoReverse(true);
		fill.setCycleCount(2);
		
		//Paralleles bewegen und Farbändern
		ParallelTransition moveAndColor = new ParallelTransition(move, fill);
		moveAndColor.setNode(dice);
		moveAndColor.setCycleCount(Animation.INDEFINITE);
		moveAndColor.play();
		
		Scene scene = new Scene(objects, 400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
