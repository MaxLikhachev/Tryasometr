package su.vistar.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import su.vistar.model.entity.UserData;
import su.vistar.repository.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder bcryptEncoder;

    public JwtUserDetailsService(UserRepository userRepository, PasswordEncoder bcryptEncoder) {
        this.userRepository = userRepository;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserData save(UserDetails user) {
        UserData newUser = new UserData();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        return userRepository.save(newUser);
    }

/*
    public UserData update(UserData user) {
        UserData newUser = findUserByUsername(user.getUsername());

        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setSecondName(user.getSecondName());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());

        return userRepository.save(newUser);
    }
    */
}