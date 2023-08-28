package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;

public interface ProbationaryStageRepository extends JpaRepository<ProbationaryStage, Long>{

	@Query("from ProbationaryStage pb where pb.employee.id = :employeeId")
	ProbationaryStage byEmployee(Long employeeId);
	
	@Query("select pb.employee.id from ProbationaryStage pb join Employee e on pb.employee.id = e.id")
	List<Long> onlyEmployeeId();

}
