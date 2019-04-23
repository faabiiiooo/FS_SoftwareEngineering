package lesson9_colorGen;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class ColorGen_View {

    protected ColorMixerPane mixerPane;
    protected Button btnSave;
    protected ListView<Color> colorList;

    private Stage stage;
    private ColorGen_Model model;

    public ColorGen_View(Stage stage, ColorGen_Model model){
        this.stage = stage;
        this.model = model;
        this.btnSave = new Button("Save");
        this.colorList = new ListView<>(model.getColorList());
        this.colorList.setCellFactory(c -> new ColorCell());

        mixerPane = new ColorMixerPane();

        VBox root = new VBox();

        root.getChildren().addAll(mixerPane, btnSave,colorList);

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.show();

    }


}
