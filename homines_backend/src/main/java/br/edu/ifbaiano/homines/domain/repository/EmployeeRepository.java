package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Query("from Employee e where (e.name like %:name% or e.siape IS NULL) AND (e.siape like %:siape% or e.name IS NULL)")
	Page<Employee> searchByNameOrSiape(String name, String siape, Pageable pageable);
	
}
