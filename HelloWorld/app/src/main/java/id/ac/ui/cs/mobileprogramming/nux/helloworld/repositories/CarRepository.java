package id.ac.ui.cs.mobileprogramming.nux.helloworld.repositories;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.models.Car;

public class CarRepository {


    HashMap<String, Car> car_map = new HashMap<>();
    private static CarRepository instance;

    private CarRepository(){

        Car[] cars = new Car[]{
                new Car("RX-7", "Racing FDS3", "1200", "Mazda", "Test 123"),
                new Car("Miata", "Racing", "unknown", "Mazda", "Test Miata"),
                new Car("Integra", "Racing", "unknown", "Acura", "Test Acura Integra"),
                new Car("Trueno AE 86", "unkwnon", "1200", "Toyota", "Tofu Boy"),
                new Car("GT-R", "Racing", "unknown","Nissan", "Nissan GT-R Blue")

        };
        for(Car c: cars) car_map.put(c.getName(), c);
    }


    public static CarRepository getInstance(){
        if(instance == null){
            instance = new CarRepository();
        }
        return instance;
    }

    @SuppressLint("NewApi")
    public List<String> getCars() {
        // Stream set SDK > 23
        return car_map.values().stream().map(Car::getName).sorted().collect(Collectors.toList());
    }

    public Car getCarDetails(String name){
        return car_map.get(name);
    }
}


