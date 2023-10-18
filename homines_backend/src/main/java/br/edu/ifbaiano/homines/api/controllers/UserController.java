package br.edu.ifbaiano.homines.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifbaiano.homines.domain.model.User;
import br.edu.ifbaiano.homines.domain.repository.UserRepository;
import br.edu.ifbaiano.homines.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public Page<User> list(@PageableDefault(size = 10) Pageable pageable){		
		return userRepository.findAll(pageable);
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> update(@PathVariable Long userId,
			@Valid @RequestBody User user){
		
		User userFromDB = userService.findOrFail(userId);
		BeanUtils.copyProperties(user, userFromDB, "id");
		userFromDB = userRepository.save(userFromDB);
		
		return ResponseEntity.ok(userFromDB);
		
	}
	
	
}
