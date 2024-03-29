package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.domain.model.Vacation;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long>{

	@Query("from Vacation v where v.employee.id = :employeeId")
	List<Vacation> vacationByEmployee(Long employeeId);
}
