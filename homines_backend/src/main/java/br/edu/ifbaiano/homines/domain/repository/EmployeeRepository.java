package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifbaiano.homines.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryQueries{

	@Query("select count(e.career) from Employee e where e.career.career = 'TAE'")
	Integer careerCountTAE();

	@Query("select count(e.career) from Employee e where e.career.career = 'Docente'")
	Integer careerCountTeacher();
	
	@Query("select count(e.career) from Employee e")
	Integer careerCount();
	
	List<Employee> findBynameLikeOrSiapeLike(String name, String siape);
	
}
