package lesson9_dataManager;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DataManagerController {

    private DataManagerModel model;
    private DataManagerView view;

    public DataManagerController(DataManagerModel model, DataManagerView view) {

        this.model = model;
        this.view = view;




        this.view.getBtnAddEntry().setOnAction(this::addEntry);
        this.view.getBtnRemoveEntry().setOnAction(this::removeEntry);

        this.model.getItems().addListener((ListChangeListener<Data>) c -> {
            while (c.next()) {
                this.view.dataTable.scrollTo(c.getFrom());
            }
        });

        this.view.colName.setOnEditCommit(editEvent -> {
            getDataFromEvent(editEvent).setPropName(editEvent.getNewValue());
        });

        this.view.colRegisseur.setOnEditCommit(editEvent -> {
            getDataFromEvent(editEvent).setPropRegisseur(editEvent.getNewValue());
        });

        this.view.colMainActor.setOnEditCommit(editEvent -> {
            getDataFromEvent(editEvent).setPropMainActor(editEvent.getNewValue());
        });

        this.view.colDuration.setOnEditCommit(editEvent -> {
            try{
               double newValue =  Double.parseDouble(editEvent.getNewValue());
                getDataFromEvent(editEvent).setPropDuration(newValue);
            } catch (NumberFormatException e){
                editEvent.getTableView().refresh();
            }
        });

        this.view.colNumOfShows.setOnEditCommit(editEvent -> {
            try {
                int newValue = Integer.parseInt(editEvent.getNewValue());
                getDataFromEvent(editEvent).setPropNumOfShows(newValue);
            } catch (NumberFormatException e){
                editEvent.getTableView().refresh();
            }
        });

        this.view.getStage().setOnCloseRequest(model::saveToFile);




    }

    private void removeEntry(Event e){

        model.getItems().remove(view.dataTable.getSelectionModel().getSelectedItem());
    }

    private void addEntry(Event e){
        model.addItem();
    }

    private Data getDataFromEvent(TableColumn.CellEditEvent<Data, String> editEvent){
        TableView<Data> tv = editEvent.getTableView();
        int rowNumber = editEvent.getTablePosition().getRow();
        return tv.getItems().get(rowNumber);
    }
}
