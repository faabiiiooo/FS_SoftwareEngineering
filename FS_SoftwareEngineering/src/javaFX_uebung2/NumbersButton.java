package javaFX_uebung2;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class NumbersButton extends Button {

    protected NumbersButton(String text) {
        super(text);
        this.setFont(new Font("Arial Black", 12));
        this.setStyle("-fx-background-color: firebrick");
        this.setStyle("-fx-text-fill: white");
        this.setStyle("-fx-background-radius: 10px");
    }


}
