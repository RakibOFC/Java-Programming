package javaInheritance;
// Simple Inheritance 1
class Vehicle{

    protected String brand = "Bajaj";

    public void honk() {

        System.out.println("Vehicle Honk: Beep, Beep!");
    }
}

class Bike extends Vehicle{

    private String modelName = "Pulsar";

    public void name(){

        System.out.println("Brand and Model: " + brand + " " + modelName);
    }
}

public class SimpleEx1 {
    
    public static void main(String[] args) {

        Bike myBike = new Bike();

        myBike.honk();
        myBike.name();
    }
}
