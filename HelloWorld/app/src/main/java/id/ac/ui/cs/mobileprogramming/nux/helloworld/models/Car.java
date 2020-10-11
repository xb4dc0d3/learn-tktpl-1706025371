package id.ac.ui.cs.mobileprogramming.nux.helloworld.models;

public class Car {

    private String name;
    private String type;
    private String cc;
    private String merk;
    private String description;

    public Car(String name, String type, String cc, String merk, String description){
        this.name = name;
        this.type = type;
        this.cc = cc;
        this.merk = merk;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMerk() {
        return merk;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCC() {
        return cc;
    }
}
