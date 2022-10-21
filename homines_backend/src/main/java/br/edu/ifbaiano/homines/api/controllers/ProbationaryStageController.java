package br.edu.ifbaiano.homines.api.controllers;

import java.util.ArrayList;
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
import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;
import br.edu.ifbaiano.homines.domain.repository.ProbationaryStageRepository;
import br.edu.ifbaiano.homines.domain.service.EmployeeService;
import br.edu.ifbaiano.homines.domain.service.ProbationaryStageService;

@RestController
@RequestMapping("/employees/{employeeId}/probationary-stage")
public class ProbationaryStageController {
	
	@Autowired
	private ProbationaryStageService probationaryStageService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProbationaryStageRepository probationaryStageRepository;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ProbationaryStage list(@PathVariable Long employeeId) {
		return probationaryStageRepository.byEmployee(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProbationaryStage create(@Valid @PathVariable Long employeeId,
			@RequestBody ProbationaryStage probationaryStage) {
		return probationaryStageService.create(employeeId, probationaryStage);
	}
	
	@PutMapping("/{probationaryStageId}")
	public ResponseEntity<ProbationaryStage> update(@Valid @PathVariable Long employeeId,
			@PathVariable Long probationaryStageId, @RequestBody ProbationaryStage probationaryStage){
		Employee employee = employeeService.findOrFail(employeeId);
		ProbationaryStage probationaryStageFromBD = probationaryStageService.findOrFail(probationaryStageId);
		
		modelMapper.map(probationaryStage, probationaryStageFromBD);
		
		probationaryStageFromBD.setEmployee(employee);
		probationaryStageFromBD = probationaryStageService.create(employeeId, probationaryStageFromBD);
		
		return ResponseEntity.ok(probationaryStageFromBD);
	}
}