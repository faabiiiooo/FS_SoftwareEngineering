package javaFX_uebung2;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class NumbersResultLabel extends Label {

    protected NumbersResultLabel(String text) {
        super(text);
        this.setMinWidth(150);
        this.setStyle("-fx-background-color: lightblue");
        this.setFont(new Font("Arial Black", 12));
    }

}
