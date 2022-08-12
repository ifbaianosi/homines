package br.edu.ifbaiano.homines.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.Vacation;
import br.edu.ifbaiano.homines.domain.repository.VacationRepository;

@Service
public class VacationService {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private VacationRepository vacationRepository;
	
	public Vacation create(Long employeeId, Vacation vacation) {
		Employee employee = employeeService.findOrFail(employeeId);
		vacation.setEmployee(employee);
		return vacationRepository.save(vacation);
	}
	
	public Vacation findOrFail(Long vacantionId) {
		return vacationRepository.findById(vacantionId)
				.orElseThrow(() -> new EntityNotFoundException(
						String .format("Férias com o id %d não foi encontrado.", vacantionId)));
	}
}
