package lesson13_portProbe.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lesson13_portProbe.model.CoPort;
import lesson13_portProbe.model.PortProbe_Model;

public class PortProbe_View {

    private PortProbe_Model model;

    private TableView<CoPort> portDisplay;
    private final Button btnScan;

    public PortProbe_View (Stage stage, PortProbe_Model model) {
        this.model = model;
        VBox root = new VBox();

        this.createPortDisplay();

        btnScan = new Button("Scan");

        root.getChildren().addAll(portDisplay,btnScan);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("PortProbe");
        stage.show();




    }

    private void createPortDisplay(){
        this.portDisplay = new TableView<>();
        TableColumn<CoPort, Integer> colPortNum = new TableColumn<>("Port ID");
        colPortNum.setCellValueFactory(c -> c.getValue().portIdProperty().asObject());

        TableColumn<CoPort, String> colPortStat = new TableColumn<>("Status");
        colPortStat.setCellValueFactory(c -> c.getValue().statusProperty());

        this.portDisplay.getColumns().addAll(colPortNum,colPortStat);
        synchronized (model.getPorts()) {
            this.portDisplay.setItems(model.getPorts());
        }

    }

    public Button getBtnScan(){ return this.btnScan; };
}
