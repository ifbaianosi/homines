package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifbaiano.homines.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
