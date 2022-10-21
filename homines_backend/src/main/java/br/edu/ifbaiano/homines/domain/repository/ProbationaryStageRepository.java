package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;

public interface ProbationaryStageRepository extends JpaRepository<ProbationaryStage, Long>{

	@Query("from ProbationaryStage pb where pb.employee.id = :employeeId")
	ProbationaryStage byEmployee(Long employeeId);
}
