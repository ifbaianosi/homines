package br.edu.ifbaiano.homines.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.Progression;
import br.edu.ifbaiano.homines.domain.repository.ProgressionRepository;

@Service
public class ProgressionService {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProgressionRepository progressionRepository;
	
	public Progression create(Long employeeId, Progression progression) {
		Employee employee = employeeService.findOrFail(employeeId);
		progression.setEmployee(employee);
		return progressionRepository.save(progression);
	}
	
	public Progression findOrFail(Long progressionId) {
		return progressionRepository.findById(progressionId)
				.orElseThrow(() -> new EntityNotFoundException(
						String .format("Progressão com o id %d não foi encontrado.", progressionId)));
	}
}
