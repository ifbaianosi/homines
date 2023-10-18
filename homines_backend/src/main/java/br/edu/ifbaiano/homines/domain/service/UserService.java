package br.edu.ifbaiano.homines.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityExistsException;
import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.User;
import br.edu.ifbaiano.homines.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		checkUserExistence(user);
		
		user.setPassword(passwordEnconder().encode(user.getPassword()));
		
		return userRepository.save(user);
	}

	public void checkUserExistence(User user) {
	
	if(userRepository.findByUser(user.getUser()).isPresent()) {
		throw new EntityExistsException("User already exists!");
	}
	}
	
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	public User findOrFail(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(
				String.format("User with id %d was not founded.", userId)));
	}
}
