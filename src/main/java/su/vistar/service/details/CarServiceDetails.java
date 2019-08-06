package su.vistar.service.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.entity.Car;
import su.vistar.repository.CarRepository;
import su.vistar.service.CarService;

import java.util.List;
import java.util.Optional;
@Service
public class CarServiceDetails implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(long id) {
        Optional<Car> optionalCarMark = carRepository.findById(id);
        Car car = optionalCarMark.isPresent() ? optionalCarMark.get() : new Car();
        return car;
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
