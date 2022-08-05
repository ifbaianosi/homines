package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifbaiano.homines.domain.model.Progression;

public interface ProgressionRepository extends JpaRepository<Progression, Long>{

}
