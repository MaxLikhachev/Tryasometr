package su.vistar.service;

import su.vistar.repository.CarRepository;
import su.vistar.model.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    //@Override
    public CarDAO add(CarDAO car) {
        return carRepository.save(car);
    }

    //@Override
    public CarDAO getById(long id) {
        Optional<CarDAO> optionalCarMark = carRepository.findById(id);
        CarDAO car = optionalCarMark.isPresent() ? optionalCarMark.get() : new CarDAO();
        return car;
    }
    //@Override
    public List<CarDAO> getAll(){return carRepository.findAll();}
    //@Override
    public CarDAO edit(CarDAO car){return carRepository.saveAndFlush(car);}

    //@Override
    public void delete(CarDAO car){carRepository.delete(car);}

    //@Override
    public void remove() {
        carRepository.deleteAll();
    }


}
