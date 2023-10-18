package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifbaiano.homines.domain.model.Situation;

public interface SituationRepository extends JpaRepository<Situation, Long>{

}
