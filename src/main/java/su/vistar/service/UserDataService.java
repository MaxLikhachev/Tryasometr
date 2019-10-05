package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.UserData;
import su.vistar.repository.UserRepository;

import java.util.List;

@Service
public class UserDataService {
    private final UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    public void save(UserData userData) {
        userRepository.save(userData);
    }

    public UserData getById(long id) {
        return userRepository.findById(id).orElseGet(UserData::new);
    }


    public List<UserData> getAll() {
        return userRepository.findAll();
    }


    public void delete(UserData userData) {
        userRepository.delete(userData);
    }


    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
