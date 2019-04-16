package lesson9_dataManager;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {


    private final SimpleStringProperty propName, propRegisseur, propMainActor;
    private final SimpleDoubleProperty propDuration;
    private final SimpleIntegerProperty propNumOfShows;

    public Data(){

        this.propName = new SimpleStringProperty("pleaseEnter!");
        this.propRegisseur = new SimpleStringProperty("pleaseEnter!");
        this.propMainActor = new SimpleStringProperty("pleaseEnter!");
        this.propDuration = new SimpleDoubleProperty(-1);
        this.propNumOfShows = new SimpleIntegerProperty(-1);

    }

    public Data(String name, String regisseur, String mainActor, double duration, int numOfShows){
        this.propName = new SimpleStringProperty(name);
        this.propRegisseur = new SimpleStringProperty(regisseur);
        this.propMainActor = new SimpleStringProperty(mainActor);
        this.propDuration = new SimpleDoubleProperty(duration);
        this.propNumOfShows = new SimpleIntegerProperty(numOfShows);
    }

    public String toString(){
        String dataString;
        dataString = this.getPropName()+";";
        dataString += this.getPropRegisseur()+";";
        dataString += this.getPropMainActor()+";";
        dataString += this.getPropDuration()+";";
        dataString += this.getPropNumOfShows()+";"+"\n";

        return  dataString;

    }


    public String getPropName() {
        return propName.get();
    }

    public SimpleStringProperty propNameProperty() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName.set(propName);
    }

    public String getPropRegisseur() {
        return propRegisseur.get();
    }

    public SimpleStringProperty propRegisseurProperty() {
        return propRegisseur;
    }

    public void setPropRegisseur(String propRegisseur) {
        this.propRegisseur.set(propRegisseur);
    }

    public String getPropMainActor() {
        return propMainActor.get();
    }

    public SimpleStringProperty propMainActorProperty() {
        return propMainActor;
    }

    public void setPropMainActor(String propMainActor) {
        this.propMainActor.set(propMainActor);
    }

    public double getPropDuration() {
        return propDuration.get();
    }

    public SimpleDoubleProperty propDurationProperty() {
        return propDuration;
    }

    public void setPropDuration(double propDuration) {
        this.propDuration.set(propDuration);
    }

    public int getPropNumOfShows() {
        return propNumOfShows.get();
    }

    public SimpleIntegerProperty propNumOfShowsProperty() {
        return propNumOfShows;
    }

    public void setPropNumOfShows(int propNumOfShows) {
        this.propNumOfShows.set(propNumOfShows);
    }
}
