package javaFX_uebung2;

public class NumbersModel {

    protected NumbersModel(){

    }

    protected String toHex(String decimal){
        Integer value = Integer.parseInt(decimal);
        return Integer.toHexString(value);
    }

    protected String toBinary(String decimal){
        Integer value = Integer.parseInt(decimal);
        return  Integer.toBinaryString(value);
    }
}
