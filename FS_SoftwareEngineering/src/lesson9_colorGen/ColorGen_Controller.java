package lesson9_colorGen;

import javafx.event.Event;

public class ColorGen_Controller {

    private ColorGen_Model model;
    private ColorGen_View view;
    private ColorMixerPane mixerPane;

    public ColorGen_Controller(ColorGen_Model model, ColorGen_View view){
        this.model = model;
        this.view = view;
        this.mixerPane = view.mixerPane;

        addColorMixerBindings();
        this.view.btnSave.setOnAction(event -> this.model.addColor());


    }

    private void addColorMixerBindings(){

        mixerPane.sldRed.valueProperty().bindBidirectional(model.redProperty());
        mixerPane.lblRed.textProperty().bind(model.redProperty().asString());

        mixerPane.sldGreen.valueProperty().bindBidirectional(model.greenProperty());
        mixerPane.lblGreen.textProperty().bind(model.greenProperty().asString());

        mixerPane.sldBlue.valueProperty().bindBidirectional(model.blueProperty());
        mixerPane.lblBlue.textProperty().bind(model.blueProperty().asString());

        mixerPane.colorDisplay.fillProperty().bind(model.colorProperty());

        mixerPane.colorDisplay.widthProperty().bind(mixerPane.widthProperty().subtract(20));
    }

    private void saveColor(Event e){

    }
}
