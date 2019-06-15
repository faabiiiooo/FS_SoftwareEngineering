package javaFX_uebung1;

public class AdderController {

    private final AdderModel model;
    private final AdderView view;

    protected AdderController(AdderModel model, AdderView view){
        this.view = view;
        this.model = model;

        //Register ourselves to listen for property changes in the model.
        // if the new value is below zero, we call view.doAnimate();
        model.getValueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue.intValue() < 0) view.doAnimate();
        }));

        //register ourselves to listen for button clicks. when the button
        //is clicked, what whatever is needed for the application to work
        view.btnAdd.setOnAction((event) -> {
            model.addToValue(Integer.parseInt(view.txtAmount.getText()));
        });
    }
}
