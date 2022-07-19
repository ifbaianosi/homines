package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.domain.model.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long>{

}
