package de.cruisecontrol.cardata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 02.10.2015.
 */
public class CarPool {
    private List<Car> cars = new ArrayList<>();

    public boolean save(){
        return false;
    }

    // ***************
    // GETTER & SETTER
    // ***************
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
