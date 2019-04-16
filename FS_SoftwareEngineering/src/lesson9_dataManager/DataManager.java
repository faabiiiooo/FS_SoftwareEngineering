package lesson9_dataManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class DataManager extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){

        DataManagerModel model = new DataManagerModel();
        DataManagerView view = new DataManagerView(primaryStage,model);
        DataManagerController controller = new DataManagerController(model,view);


    }

}
