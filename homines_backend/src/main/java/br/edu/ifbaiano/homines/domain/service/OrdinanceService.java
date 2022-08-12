package br.edu.ifbaiano.homines.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.Ordinance;
import br.edu.ifbaiano.homines.domain.repository.OrdinanceRepository;

@Service
public class OrdinanceService {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrdinanceRepository ordinanceRepository;
	
	public Ordinance create(Long employeeId, Ordinance ordinance) {
		Employee employee = employeeService.findOrFail(employeeId);
		ordinance.setEmployee(employee);
		return ordinanceRepository.save(ordinance);
	}
	
	public Ordinance findOrFail(Long ordinanceId) {
		return ordinanceRepository.findById(ordinanceId)
				.orElseThrow(() -> new EntityNotFoundException(
						String .format("Férias com o id %d não foi encontrado.", ordinanceId)));
	}

}
