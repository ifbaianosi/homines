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
import br.edu.ifbaiano.homines.domain.model.Progression;
import br.edu.ifbaiano.homines.domain.repository.ProgressionRepository;
import br.edu.ifbaiano.homines.domain.service.EmployeeService;
import br.edu.ifbaiano.homines.domain.service.ProgressionService;

@RestController
@RequestMapping("/employees/{employeeId}/progression")
public class ProgressionController {
	
	@Autowired
	private ProgressionRepository progressionRepository;
	
	@Autowired
	private ProgressionService progressionService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Progression> list(@Valid @PathVariable Long employeeId){
		return progressionRepository.progressionByEmployee(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Progression create(@Valid @PathVariable Long employeeId, @RequestBody Progression progression) {
			return progressionService.create(employeeId, progression);
	}
	
	@PutMapping("{progressionId}")
	public ResponseEntity<Progression> update (@PathVariable Long employeeId, 
			@PathVariable Long progressionId, @RequestBody Progression progression) {
		Employee employee = employeeService.findOrFail(employeeId);
		Progression progressionFromBD = progressionService.findOrFail(progressionId);
		
		modelMapper.map(progression, progressionFromBD);
		
		progressionFromBD.setEmployee(employee);
		progressionFromBD = progressionRepository.save(progressionFromBD);
		
		return ResponseEntity.ok(progressionFromBD);
	}
}
