package javaFX_uebung1;

import javafx.animation.ScaleTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AdderView {
    private AdderModel model;
    private Stage stage;

    protected Label lblTotal = new Label();
    protected Button btnAdd = new Button("Add amount to total");
    protected TextField txtAmount = new TextField("0");

    private ScaleTransition pulse;

    protected AdderView(Stage stage, AdderModel model){
        this.stage = stage;
        this.model = model;

        //Bind lblTotal, so that it automatically updates from the model
        lblTotal.textProperty().bind(model.getValueProperty().asString());

        //Create Layout
        Pane root = createLayout();

        pulse = createAnimation();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Adder");
    }

    private Pane createLayout(){
        VBox vBox = new VBox();
        Region spacer = new Region();
        vBox.getChildren().addAll(txtAmount,btnAdd,spacer,lblTotal);
        vBox.setSpacing(5);
        vBox.setVgrow(spacer, Priority.ALWAYS);
        txtAmount.prefWidthProperty().bind(vBox.widthProperty());
        btnAdd.prefWidthProperty().bind(vBox.widthProperty());
        return vBox;
    }

    private ScaleTransition createAnimation(){
        ScaleTransition toCreate = new ScaleTransition(Duration.millis(1500),lblTotal);
        toCreate.setByX(0.5);
        toCreate.setByY(0.5);
        toCreate.setCycleCount(2);
        toCreate.setAutoReverse(true);

        return toCreate;
    }

    public void start(){
        stage.show();
    }

    protected Stage getStage(){ return this.stage;}

    protected void doAnimate(){
        pulse.play();
    }
}
