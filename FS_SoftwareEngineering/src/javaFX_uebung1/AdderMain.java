package javaFX_uebung1;

import javafx.application.Application;
import javafx.stage.Stage;

public class AdderMain extends Application {

    private AdderView view;
    private AdderController controller;
    private AdderModel model;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){
         model = new AdderModel();
         view = new AdderView(stage,model);
         controller = new AdderController(model,view);

         view.start();

    }
}
