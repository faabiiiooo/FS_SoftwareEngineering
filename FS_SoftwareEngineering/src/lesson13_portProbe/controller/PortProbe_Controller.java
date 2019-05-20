package lesson13_portProbe.controller;

import lesson13_portProbe.model.PortProbe_Model;
import lesson13_portProbe.view.PortProbe_View;

public class PortProbe_Controller {

    private PortProbe_Model model;
    private PortProbe_View view;

    public PortProbe_Controller(PortProbe_Model model, PortProbe_View view){
        this.model = model;
        this.view = view;

        this.view.getBtnScan().setOnAction(e -> {
            model.scanPorts();
        });

    }

}
