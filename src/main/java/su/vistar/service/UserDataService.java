package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.UserData;

import java.util.List;

@Service
public interface UserDataService {
    UserData add(UserData userData);

    UserData getById(long id);

    List<UserData> getAll();

    UserData edit(UserData userData);

    void delete(UserData userData);

    UserData findByUsername(String username);
}
