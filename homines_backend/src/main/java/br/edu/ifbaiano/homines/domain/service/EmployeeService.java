package br.edu.ifbaiano.homines.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public void delete(Long employeeId) {
		Employee employee = findOrFail(employeeId);
		employeeRepository.delete(employee);
		employeeRepository.flush();

	}
	
	public Employee findOrFail(Long employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EntityNotFoundException(String .format("Servidor com o id %d não foi encontrado.", employeeId)));
	}
}
