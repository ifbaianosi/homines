package br.edu.ifbaiano.homines.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepository;
import br.edu.ifbaiano.homines.domain.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> list(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee show(@PathVariable Long employeeId) {
		return employeeService.findOrFail(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> update(@PathVariable Long employeeId, 
			@Valid @RequestBody Employee employee) {
		Employee employeeFromBD = employeeService.findOrFail(employeeId);
		BeanUtils.copyProperties(employee, employeeFromBD, "id");
		employeeFromBD = employeeRepository.save(employeeFromBD);
		
		return ResponseEntity.ok(employeeFromBD);
	}
	
	@DeleteMapping("/{employeeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long employeeId){
		employeeService.delete(employeeId);
		return ResponseEntity.noContent().build();
	}
}
