package br.edu.ifbaiano.homines.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;
import br.edu.ifbaiano.homines.domain.repository.ProbationaryStageRepository;

@Service
public class ProbationaryStageService {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProbationaryStageRepository probationaryStageRepository;
	
	
	public ProbationaryStage create(Long employeeId, ProbationaryStage probationaryStage) {
		Employee employee = employeeService.findOrFail(employeeId);
		probationaryStage.setEmployee(employee);
		return probationaryStageRepository.save(probationaryStage);
	}
	
	public ProbationaryStage findOrFail(Long probationaryStageId) {
		return probationaryStageRepository.findById(probationaryStageId)
				.orElseThrow(() -> new EntityNotFoundException(
						String .format("Estágio probatório com id %d não foi encontrado.", probationaryStageId)));
	}
}