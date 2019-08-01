package su.vistar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import su.vistar.model.dao.UserDAO;
import su.vistar.model.dto.UserDTO;
import su.vistar.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDAO user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public UserDetails signUpUser(UserDTO newUser) throws UsernameNotFoundException {
		UserDAO user = userRepository.findByUsername(newUser.getUsername());
		if (user != null) {
			throw new UsernameNotFoundException("User found with username: " + newUser.getUsername());
		}
		return new User(newUser.getUsername(), newUser.getPassword(), new ArrayList<>());
	}

	public UserDAO findUserByUsername(String username)throws UsernameNotFoundException {
		UserDAO user = userRepository.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException("User not found with username: " + username);

		return user;
	}
	public UserDAO save(UserDTO user) {
		UserDAO newUser = new UserDAO();

		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setSecondName(user.getSecondName());
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());

		return userRepository.save(newUser);
	}
}