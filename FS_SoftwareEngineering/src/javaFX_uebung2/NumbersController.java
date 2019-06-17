package javaFX_uebung2;

public class NumbersController {

    final private NumbersModel model;
    final private NumbersView view;

    protected NumbersController(NumbersModel model, NumbersView view) {
        this.model = model;
        this.view = view;


        view.root.txtDecimal.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\d+")){
                view.root.btnBinary.setDisable(true);
                view.root.btnHex.setDisable(true);
            } else {
                view.root.btnHex.setDisable(false);
                view.root.btnBinary.setDisable(false);
            }
        }));

        view.root.btnHex.setOnAction(e -> {
            view.root.lblResult.setText(model.toHex(view.root.txtDecimal.getText()));
        });

        view.root.btnBinary.setOnAction( e -> {
            view.root.lblResult.setText(model.toBinary(view.root.txtDecimal.getText()));
        });



    }


    }
