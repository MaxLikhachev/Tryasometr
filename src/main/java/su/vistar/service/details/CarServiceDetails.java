package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Car;
import su.vistar.repository.CarRepository;
import su.vistar.service.CarService;

import java.util.List;


@Service
public class CarServiceDetails implements CarService {
    private final CarRepository carRepository;

    public CarServiceDetails(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(long id) {
        return carRepository.findById(id).orElseGet(Car::new);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car edit(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void remove() {
        carRepository.deleteAll();
    }
}
