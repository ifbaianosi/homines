package br.edu.ifbaiano.homines.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.api.DTO.EmployeeDTO;
import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.Ordinance;
import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;
import br.edu.ifbaiano.homines.domain.model.Progression;
import br.edu.ifbaiano.homines.domain.model.Vacation;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepository;
import br.edu.ifbaiano.homines.domain.repository.OrdinanceRepository;
import br.edu.ifbaiano.homines.domain.repository.ProbationaryStageRepository;
import br.edu.ifbaiano.homines.domain.repository.ProgressionRepository;
import br.edu.ifbaiano.homines.domain.repository.VacationRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProbationaryStageRepository probationaryStageRepository;

	@Autowired
	private ProgressionRepository progressionRepository;

	@Autowired
	private VacationRepository vacationRepository;

	@Autowired
	private OrdinanceRepository ordinanceRepository;

	@Transactional
	public void delete(Long employeeId) {
		Employee employee = findOrFail(employeeId);
		employeeRepository.delete(employee);
		employeeRepository.flush();

	}

	public Employee findOrFail(Long employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException(
				String.format("Servidor com o id %d não foi encontrado.", employeeId)));
	}

	public ProbationaryStage probationaryStage(Long employeeId) {

		probationaryStageRepository.byEmployee(employeeId);

		return null;
	}

	public EmployeeDTO createEmployeeDTO(Long employeeId) {
		
		Employee employee = new Employee();
		ProbationaryStage probationaryStage = new ProbationaryStage();
		Progression progression = new Progression();
		Vacation vacation = new Vacation();
		List<Ordinance> ordinances = new ArrayList<>();
		EmployeeDTO employeeDTO = new EmployeeDTO();

		employee = findOrFail(employeeId);
		probationaryStage = probationaryStageRepository.byEmployee(employeeId);
		progression = progressionRepository.progressionByEmployee(employeeId);
		vacation = vacationRepository.vacationByEmployee(employeeId);
		ordinances = ordinanceRepository.ordinanceByEmployee(employeeId);

		employeeDTO.setName(employee.getName());
		employeeDTO.setSiape(employee.getSiape());
		employeeDTO.setEmail(employee.getEmail());
		
		if((probationaryStage.getFirstAvaliationDateEnd().isAfter(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateBegin().isAfter(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isAfter(LocalDate.now()))
				|| probationaryStage.getFirstAvaliationDateEnd().isEqual(LocalDate.now())) {
			
			employeeDTO.setProbationaryStageAvaliation("1ª Avaliação");
			employeeDTO.setNextAvaliation(probationaryStage.getSecondAvaliationDateBegin().toString());
			
		}else if((probationaryStage.getFirstAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateEnd().isAfter(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isAfter(LocalDate.now()))
				|| probationaryStage.getSecondAvaliationDateEnd().isEqual(LocalDate.now())) {
			
			employeeDTO.setProbationaryStageAvaliation("2ª Avaliação");
			employeeDTO.setNextAvaliation(probationaryStage.getThirdAvaliationDateBegin().toString());
		}else if((probationaryStage.getFirstAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isBefore(LocalDate.now())) 
				|| probationaryStage.getThirdAvaliationDateBegin().isEqual(LocalDate.now())) {
			
			employeeDTO.setProbationaryStageAvaliation("3ª Avaliação");
			employeeDTO.setNextAvaliation("Última avaliação");
		}
		

		if (progression.getActualLevel() != null && progression.getLastProgressionDate() != null
				&& progression.getNextLevel() != null && progression.getNextProgressionDate() != null) {
			employeeDTO
					.setActualProgression(progression.getActualLevel() + " - " + progression.getLastProgressionDate());
			employeeDTO.setNextProgression(progression.getNextLevel() + " - " + progression.getNextProgressionDate());

		}

		if (vacation != null) {
			employeeDTO.setVacationYear(vacation.getYear());
		}

		employeeDTO.setOrdinance(ordinances.get(0).getOrdinance());
		employeeDTO.setOrdinancesDate(ordinances.get(0).getDate());		
		employeeDTO.setTotalOrdinances(ordinances.size());

		return employeeDTO;
	}
}
