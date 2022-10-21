package br.edu.ifbaiano.homines.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.Vacation;
import br.edu.ifbaiano.homines.domain.repository.VacationRepository;
import br.edu.ifbaiano.homines.domain.service.EmployeeService;
import br.edu.ifbaiano.homines.domain.service.VacationService;

@RestController
@RequestMapping("/employees/{employeeId}/vacation")
public class VacationController {

	@Autowired
	VacationRepository vacationRepository;
	
	@Autowired
	VacationService vacationService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping
	public Vacation list(@PathVariable Long employeeId) {
		return vacationRepository.vacationByEmployee(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vacation create(@Valid @PathVariable Long employeeId,
			@RequestBody Vacation vacation) {
		return vacationService.create(employeeId, vacation);
	}
	
	@PutMapping("/{vacationId}")
	public ResponseEntity<Vacation> update(@Valid @PathVariable Long employeeId,
			@PathVariable Long vacationId, @RequestBody Vacation vacation){
		Employee employee = employeeService.findOrFail(employeeId);
		Vacation vacationFromBD = vacationService.findOrFail(vacationId);
		
		modelMapper.map(vacation, vacationFromBD, "year");
		
		vacationFromBD.setEmployee(employee);
		vacationFromBD = vacationRepository.save(vacationFromBD);
		
		return ResponseEntity.ok(vacationFromBD);
	}
	
}
