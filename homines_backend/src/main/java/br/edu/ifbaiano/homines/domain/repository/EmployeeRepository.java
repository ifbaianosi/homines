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
	
	@Query("from Employee e inner join Career c on e.career.id=c.id "
			+ "inner join Class cl on e.classes.id=cl.id  "
			+ "inner join Stand s on e.stand.id=s.id "
			+ "inner join Post p on e.post.id=p.id "
			+ "inner join Sector se on e.sector.id=se.id "
			+ "right join Situation sit on e.situation.id=sit.id "
			+ "where e.id = :employeeId")
	Employee lookEmployee(Long employeeId);
}
