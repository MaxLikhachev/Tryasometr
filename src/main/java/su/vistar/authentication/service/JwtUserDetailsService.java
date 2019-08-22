package su.vistar.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import su.vistar.model.entity.UserData;
import su.vistar.repository.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getAuthorities()));
    }
    public String getPassword (String password){
        return bCryptEncoder.encode(password);
    }
/*
    public UserData save(UserData user) {
        UserData newUser = userRepository.findByUsername(user.getUsername());

        newUser.setPassword(bCryptEncoder.encode(user.getPassword()));
        newUser.setSecondName(user.getSecondName());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());

        return userRepository.save(user);
    }*/
}