package su.vistar.service.details;

import su.vistar.model.dao.UserCarDAO;
import su.vistar.repository.UserCarRepository;
import su.vistar.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCarServiceDetails implements UserCarService {
    @Autowired
    private UserCarRepository userCarRepository;
    @Override
    public UserCarDAO add(UserCarDAO userCar){return userCarRepository.save(userCar);}
    @Override
    public List<UserCarDAO> getAllByID(long user_id){ return userCarRepository.findAllById(user_id); }
    @Override
    public void delete(UserCarDAO userCar){userCarRepository.delete(userCar);}
    @Override
    public void remove(){userCarRepository.deleteAll();}
}
