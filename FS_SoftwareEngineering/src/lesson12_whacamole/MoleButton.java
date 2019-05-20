package lesson12_whacamole;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MoleButton extends Button implements Runnable, EventHandler<ActionEvent> {

    private final Image moleIcon = new Image(MoleButton.class.getResourceAsStream("mole.gif"));
    private final Image emptyIcon = new Image(MoleButton.class.getResourceAsStream("empty.gif"));

    private final ImageView mole = new ImageView(moleIcon);
    private final ImageView empty = new ImageView(emptyIcon);

    private Thread t;
    private Whacamole mainProgram = new Whacamole();

    public MoleButton(Whacamole mainProgram){
        this.mainProgram = mainProgram;

        this.setGraphic(empty);
        this.setDisable(true);
        this.setOnAction(this);

        t = new Thread(this);
        t.start();



    }

    @Override
    public void handle(ActionEvent e){
        mainProgram.whack();
    }

    public void run() {
        while (true) {
            this.setDisable(Math.random() < 0.7);
            Platform.runLater(() -> {
                if (this.isDisabled()) {
                    this.setGraphic(empty);
                } else {
                    this.setGraphic(mole);
                }
            });
            try {
                Thread.sleep(300);
            } catch (Exception e) {

            }
        }
    }
}
