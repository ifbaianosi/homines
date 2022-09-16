package br.edu.ifbaiano.homines.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.User;
import br.edu.ifbaiano.homines.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		findOrFail(user);
		
		user.setPassword(passwordEnconder().encode(user.getPassword()));
		
		return userRepository.save(user);
	}

	public void findOrFail(User user) {
		userRepository.findByUser(user.getUser())
				.orElseThrow(()-> new EntityNotFoundException("Usuário Já existe."));

	}
	
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
}
