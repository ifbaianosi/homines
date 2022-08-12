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
import br.edu.ifbaiano.homines.domain.model.Ordinance;
import br.edu.ifbaiano.homines.domain.repository.OrdinanceRepository;
import br.edu.ifbaiano.homines.domain.service.EmployeeService;
import br.edu.ifbaiano.homines.domain.service.OrdinanceService;

@RestController
@RequestMapping("/employees/{employeeId}/ordinance")
public class OrdinanceController {
	
	@Autowired
	private OrdinanceRepository ordinanceRepository;
	
	@Autowired
	private OrdinanceService ordinanceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Ordinance> list(@PathVariable Long employeeId){
		return ordinanceRepository.ordinanceByEmployee(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ordinance create(@Valid @PathVariable Long employeeId,
			@RequestBody Ordinance ordinance) {
		return ordinanceService.create(employeeId, ordinance);
	}
	
	@PutMapping("{ordinanceId}")
	public ResponseEntity<Ordinance> update(@Valid @PathVariable Long employeeId,
			@PathVariable Long ordinanceId, @RequestBody Ordinance ordinance){
		Employee employee = employeeService.findOrFail(employeeId);
		Ordinance ordinanceFromBD = ordinanceService.findOrFail(ordinanceId);
		
		modelMapper.map(ordinance, ordinanceFromBD);
		
		ordinanceFromBD.setEmployee(employee);
		ordinanceFromBD = ordinanceRepository.save(ordinanceFromBD);
		
		return ResponseEntity.ok(ordinanceFromBD);
	}

}
