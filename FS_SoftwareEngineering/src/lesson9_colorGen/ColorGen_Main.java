package lesson9_colorGen;

import javafx.application.Application;
import javafx.stage.Stage;

public class ColorGen_Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){

        ColorGen_Model model = new ColorGen_Model();
        ColorGen_View view = new ColorGen_View(primaryStage, model);
        ColorGen_Controller controller = new ColorGen_Controller(model, view);



    }
}
