package javaFX_uebung1;

import javafx.beans.property.SimpleIntegerProperty;

public class AdderModel {

    private final SimpleIntegerProperty value;

    protected AdderModel(){
        value = new SimpleIntegerProperty(0);
    }

    public void addToValue(int amount){
        setValue(getValue() + amount);
    }

    public SimpleIntegerProperty getValueProperty(){ return this.value; }

    public int getValue(){ return this.value.get(); }

    public void setValue(int newValue){ this.value.set(newValue);}
}
