package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.domain.model.Ordinance;

@Repository
public interface OrdinanceRepository extends JpaRepository<Ordinance, Long>{
	
	@Query("from Ordinance o where o.employee.id = :employeeId")
	List<Ordinance> ordinanceByEmployee(Long employeeId);
}
