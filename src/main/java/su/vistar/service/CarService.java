package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.entity.Car;

import java.util.List;


@Service
public interface CarService {
    Car add(Car car);

    Car getById(long id);

    List<Car> getAll();

    Car edit(Car car);

    void delete(Car car);

    void remove();
}
