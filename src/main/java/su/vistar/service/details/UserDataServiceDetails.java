package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.UserData;
import su.vistar.repository.UserRepository;
import su.vistar.service.UserDataService;

import java.util.List;

@Service
public class UserDataServiceDetails implements UserDataService {
    private final UserRepository userRepository;

    public UserDataServiceDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserData add(UserData userData) {
        return userRepository.save(userData);
    }

    @Override
    public UserData getById(long id) {
        return userRepository.findById(id).orElseGet(UserData::new);
    }

    @Override
    public List<UserData> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserData edit(UserData userData) {
        return userRepository.saveAndFlush(userData);
    }

    @Override
    public void delete(UserData userData) {
        userRepository.delete(userData);
    }

    @Override
    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
