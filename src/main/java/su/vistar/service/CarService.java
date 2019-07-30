package su.vistar.service;


import su.vistar.model.dao.CarDAO;

import java.util.List;

public interface CarService {
    CarDAO add(CarDAO car);
    CarDAO getById(long id);
    List<CarDAO> getAllByUserID(long id);
    void delete(CarDAO car);
    void remove();
}
