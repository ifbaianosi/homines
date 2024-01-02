package br.edu.ifbaiano.homines.api.controllers;


import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.edu.ifbaiano.homines.api.DTO.overview.EmployeeDTO;
import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO;
import br.edu.ifbaiano.homines.api.DTO.query.QueryCount;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepository;
import br.edu.ifbaiano.homines.domain.service.EmployeeService;
import br.edu.ifbaiano.homines.domain.service.QueryService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private QueryService queryService;
	
	@Autowired
	private EmployeeService employeeService;
		
	@GetMapping
	public Page<Employee> list(@PageableDefault(size =10) Pageable pageable){
		return employeeRepository.findAll(pageable);
	}
	
	@GetMapping("/by-name-or-siape")
	public Page<Employee> findByName(@PageableDefault(size =10) String name, String siape, Pageable pageable){
		return employeeRepository.searchByNameOrSiape(name, siape, pageable);
	}
	
	@GetMapping("/career-count")
	public HashMap<String, Integer> careerCount(){
		HashMap<String, Integer> career = new HashMap<String, Integer>();
		career.put("TAE", employeeRepository.careerCountTAE());
		career.put("Teacher", employeeRepository.careerCountTeacher());
		career.put("All", employeeRepository.careerCount());
		
		return career;
	}
	
	@GetMapping("/filter-count")
	public QueryCount filterCount(String career, String classes, String stand, String post, String sector, String avaliation, String situation){
		return employeeRepository.filterCount(career, classes, stand, post, sector, avaliation, situation);
	}

	@GetMapping(path = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<EmployeeQueryDTO> query(String career, String classes, String stand, String post, String sector, String avaliation, String situation, Pageable pageable){
		return employeeRepository.find(career, classes, stand, post, sector, avaliation, situation, pageable);
	}
	
	@GetMapping(path = "/query", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> queryPdf(String career, String classes, String stand, String post, String sector, String avaliation, String situation, Pageable pageable){
		
		byte[] bytesPdf = queryService.query(career, classes, stand, post, sector, avaliation, situation, pageable);
		
		var headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline");
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_PDF)
				.headers(headers)
				.body(bytesPdf);
	}	

	@GetMapping("/{employeeId}")
	public EmployeeDTO show(@PathVariable Long employeeId) {
			
		return employeeService.createEmployeeDTO(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@Valid @RequestBody Employee employee) {
		return employeeService.create(employee);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> update(@PathVariable Long employeeId, 
			@Valid @RequestBody Employee employee) {
		Employee employeeFromBD = employeeService.update(employee, employeeId);
		
		return ResponseEntity.ok(employeeFromBD);
	}
	
	@DeleteMapping("/{employeeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long employeeId){
		employeeService.delete(employeeId);
		return ResponseEntity.noContent().build();
	}
}
