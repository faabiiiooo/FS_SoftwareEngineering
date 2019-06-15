package javaFX_uebung2;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumbersView {
    private NumbersModel model;
    private Stage stage;

    NumbersLayoutPane root;

    protected NumbersView(Stage stage, NumbersModel model){
        this.stage = stage;
        this.model = model;

        root = new NumbersLayoutPane();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Number Converter");

    }

    public void start(){ stage.show();}

    protected Stage getStage(){ return this.stage; }
}
