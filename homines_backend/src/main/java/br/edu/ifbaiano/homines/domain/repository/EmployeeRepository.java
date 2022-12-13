package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifbaiano.homines.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select count(e.career) from Employee e where e.career = 'TAE'")
	Integer careerCountTAE();

	@Query("select count(e.career) from Employee e where e.career = 'Docente'")
	Integer careerCountTeacher();
	
	@Query("select count(e.career) from Employee e")
	Integer careerCount();
}
