package lesson13_portProbe.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CoPort {

    private final SimpleIntegerProperty portId = new SimpleIntegerProperty();
    private final SimpleStringProperty status = new SimpleStringProperty();

    public CoPort(int portId, String status){

        this.status.set(status);
        this.portId.set(portId);

    }

    public String toString(){
        String returnString = "\n#####";
        returnString+= "\nPortNr: "+this.getPortId()+"\n";
        returnString+= "Status: "+this.getStatus();

        return returnString;
    }

    public int getPortId() {
        return portId.get();
    }

    public SimpleIntegerProperty portIdProperty() {
        return portId;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }
}
