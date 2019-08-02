package su.vistar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import su.vistar.entity.UserData;
import su.vistar.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public UserDetails signUpUser(UserData newUser) throws UsernameNotFoundException {
		UserData user = userRepository.findByUsername(newUser.getUsername());
		if (user != null) {
			throw new UsernameNotFoundException("User found with username: " + newUser.getUsername());
		}
		return new User(newUser.getUsername(), newUser.getPassword(), new ArrayList<>());
	}

	public UserData findUserByUsername(String username)throws UsernameNotFoundException {
		UserData user = userRepository.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException("User not found with username: " + username);

		return user;
	}

	//TODO Refactor duplicate code
	public UserData save(UserData user) {
		UserData newUser = new UserData();

		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setSecondName(user.getSecondName());
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());

		return userRepository.save(newUser);
	}

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
}