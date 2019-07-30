package su.vistar.service.details;

import su.vistar.model.dao.UserCarDAO;
import su.vistar.repository.CarRepository;
import su.vistar.model.dao.CarDAO;
import su.vistar.repository.UserCarRepository;
import su.vistar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceDetails implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserCarRepository userCarRepository;

    @Override
    public CarDAO add(CarDAO car) {
        return carRepository.save(car);
    }

    @Override
    public CarDAO getById(long id) {
        Optional<CarDAO> optionalCarMark = carRepository.findById(id);
        CarDAO car = optionalCarMark.isPresent() ? optionalCarMark.get() : new CarDAO();
        return car;
    }

    @Override
    public List<CarDAO> getAllByUserID(long id){
        List<UserCarDAO> userCars = userCarRepository.findAllById(id);
        List<CarDAO> cars = new ArrayList<>();

        for(UserCarDAO userCar : userCars)
            cars.add(getById(userCar.getCarID()));

        return cars;
    }
    @Override
    public void delete(CarDAO car){carRepository.delete(car);}

    @Override
    public void remove() {
        carRepository.deleteAll();
    }
}
