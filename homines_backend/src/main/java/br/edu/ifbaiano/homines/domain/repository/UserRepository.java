package br.edu.ifbaiano.homines.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifbaiano.homines.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional <User> findByUser(String user);

}
