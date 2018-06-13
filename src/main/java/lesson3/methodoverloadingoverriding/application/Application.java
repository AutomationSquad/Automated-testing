package lesson3.methodoverloadingoverriding.application;


import lesson3.methodoverloadingoverriding.model.Car;
import lesson3.methodoverloadingoverriding.model.Helicopter;
import lesson3.methodoverloadingoverriding.model.Vehicle;
import lesson3.methodoverloadingoverriding.util.Multiplier;

import java.util.ArrayList;
import java.util.List;

public class Application {
    
    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier();
//        System.out.println(multiplier.multiply(10, 10));
//        System.out.println(multiplier.multiply(10, 10, 10));
//        System.out.println(multiplier.multiply(10, 10.5));
//        System.out.println(multiplier.multiply(10.5, 10.5));
        
//        Vehicle vehicle = new Vehicle();
//        System.out.println(vehicle.accelerate(100));
//        System.out.println(vehicle.run());
//        System.out.println(vehicle.stop());
////
//        Vehicle car = new Car();
//        System.out.println(car.accelerate(80));
//        System.out.println(car.run());
//        System.out.println(car.stop());

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Helicopter());
        vehicles.add(new Car());
        vehicles.add(new Vehicle());

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.accelerate(10));
        }
    }
}
