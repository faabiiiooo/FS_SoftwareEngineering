package lesson9_dataManager;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class DataManagerView {

    private Stage stage;
    private DataManagerModel model;
    private VBox layout;
    private Button btnAddEntry, btnRemoveEntry;

    protected TableView<Data> dataTable;
    protected TableColumn<Data, String> colName, colRegisseur, colMainActor;
    protected TableColumn<Data, String>colDuration;
    protected TableColumn<Data, String>colNumOfShows;


    public DataManagerView(Stage stage, DataManagerModel model){
        this.stage = stage;
        this.model = model;
        this.dataTable = createTableView();
        this.layout = new VBox();
        this.btnAddEntry = new Button("Add entry");
        this.btnRemoveEntry = new Button("Remove Entry");
        HBox controls = new HBox();
        controls.getChildren().addAll(btnAddEntry,btnRemoveEntry);


        layout.getChildren().addAll(dataTable,controls);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
        this.stage.setTitle("Data Manager");
        this.stage.show();


    }

    private TableView<Data> createTableView(){
        dataTable = new TableView<>();
        dataTable.setEditable(true);

        colName = new TableColumn<Data, String>("Filmname");
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setCellValueFactory(d -> d.getValue().propNameProperty());
        dataTable.getColumns().add(colName);

        colRegisseur = new TableColumn<>("Regisseur");
        colRegisseur.setCellFactory(TextFieldTableCell.forTableColumn());
        colRegisseur.setCellValueFactory(d -> d.getValue().propRegisseurProperty());
        dataTable.getColumns().add(colRegisseur);

        colMainActor = new TableColumn<>("Main actor");
        colMainActor.setCellFactory(TextFieldTableCell.forTableColumn());
        colMainActor.setCellValueFactory(d -> d.getValue().propMainActorProperty());
        dataTable.getColumns().add(colMainActor);

        colDuration = new TableColumn<>("Duration");
        colDuration.setCellFactory(TextFieldTableCell.forTableColumn());
        colDuration.setCellValueFactory(d -> Bindings.format("%.2f",d.getValue().propDurationProperty()));
        dataTable.getColumns().add(colDuration);

        colNumOfShows = new TableColumn<>("Played..");
        colNumOfShows.setCellFactory(TextFieldTableCell.forTableColumn());
        colNumOfShows.setCellValueFactory(d -> Bindings.format("%02d",d.getValue().propNumOfShowsProperty()));
        dataTable.getColumns().add(colNumOfShows);

        dataTable.setItems(model.getItems());

        return dataTable;

    }

    public Button getBtnAddEntry(){
        return this.btnAddEntry;
    }

    public Button getBtnRemoveEntry(){return this.btnRemoveEntry; }

    public Stage getStage(){
        return this.stage;
    }
}
