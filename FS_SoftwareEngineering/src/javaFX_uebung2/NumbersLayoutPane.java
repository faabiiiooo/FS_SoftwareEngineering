package javaFX_uebung2;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class NumbersLayoutPane extends HBox {

    protected TextField txtDecimal = new TextField();
    protected NumbersButton btnHex, btnBinary;
    protected NumbersResultLabel lblResult;

    protected NumbersLayoutPane(){
        btnHex = new NumbersButton("To Hex");
        btnBinary = new NumbersButton("To Binary");
        lblResult = new NumbersResultLabel("");

        Region spacerL = new Region();
        Region spacerR = new Region();

        VBox btns = new VBox();
        btns.getChildren().addAll(btnHex,btnBinary);
        btns.setSpacing(5);
        btns.setAlignment(Pos.CENTER);

        this.getChildren().addAll(txtDecimal,spacerL,btns,spacerR,lblResult);
        this.setSpacing(5);
        this.setHgrow(spacerL, Priority.ALWAYS);
        this.setHgrow(spacerR, Priority.ALWAYS);
        this.setAlignment(Pos.CENTER);

    }



}
