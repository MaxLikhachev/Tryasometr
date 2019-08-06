package su.vistar.model.response;

import su.vistar.model.entity.Brand;
import su.vistar.model.entity.Car;

import java.io.Serializable;


public class CarResponse implements Serializable {
    private float min;
    private float max;
    private int year;

    private String brand;
    private String model;

    public CarResponse(Car car, Brand brand) {
        this.max = car.getMax();
        this.min = car.getMin();
        this.year = car.getYear();
        this.model = car.getModel().getName();
        this.brand = brand.getName();
    }
}
