package lesson13_portProbe;

import javafx.application.Application;
import javafx.stage.Stage;
import lesson13_portProbe.controller.PortProbe_Controller;
import lesson13_portProbe.model.PortProbe_Model;
import lesson13_portProbe.view.PortProbe_View;

public class PortProbe extends Application {

    public static final int MAX_PORTNUM = 65535;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){

        PortProbe_Model model = new PortProbe_Model();
        PortProbe_View view = new PortProbe_View(stage,model);
        PortProbe_Controller controller = new PortProbe_Controller(model,view);

    }


}
