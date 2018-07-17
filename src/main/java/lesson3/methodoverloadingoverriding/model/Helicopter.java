package lesson3.methodoverloadingoverriding.model;

public class Helicopter extends Vehicle {

    public String accelerate(long mph) {
        return "The helocopter accelerates at : " + mph + " MPH.";
    }
}
