package javaFX_uebung2;

import javafx.application.Application;
import javafx.stage.Stage;

public class NumbersMain extends Application {

    private NumbersView view;
    private NumbersController controller;
    private NumbersModel model;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){
        model = new NumbersModel();
        view = new NumbersView(stage,model);
        controller = new NumbersController(model,view);
        view.start();
    }
}
