package lesson9_colorGen;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class ColorMixerPane extends GridPane {

    protected Slider sldRed, sldGreen, sldBlue;

    protected Label lblRed, lblGreen, lblBlue;

    protected Rectangle colorDisplay;

    public ColorMixerPane(){

        sldRed = new Slider(0.0,255,0);
        sldGreen = new Slider(0.0,255,0);
        sldBlue = new Slider(0.0,255,0);

        lblRed = new Label();
        lblGreen = new Label();
        lblBlue = new Label();

        colorDisplay = new Rectangle();
        colorDisplay.setHeight(100);

        this.add(sldRed, 0,0);
        this.add(lblRed,1,0);

        this.add(sldGreen,0,1);
        this.add(lblGreen, 1,1);

        this.add(sldBlue,0,2);
        this.add(lblBlue,1,2);

        this.add(colorDisplay,0,3,2,1);


    }




}
