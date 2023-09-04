package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifbaiano.homines.domain.model.Progression;

public interface ProgressionRepository extends JpaRepository<Progression, Long>{
	
	@Query("from Progression p where p.employee.id = :employeeId")
	List<Progression> progressionByEmployee(Long employeeId);
	
}
