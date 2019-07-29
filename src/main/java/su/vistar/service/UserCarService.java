package su.vistar.service;


import su.vistar.model.dao.UserCarDAO;

import java.util.List;

public interface UserCarService {
    UserCarDAO add(UserCarDAO userCar);
    List<UserCarDAO> getAllByID(long user_id);
    void remove();
}
