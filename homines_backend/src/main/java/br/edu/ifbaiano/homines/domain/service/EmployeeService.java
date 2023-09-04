package br.edu.ifbaiano.homines.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.api.DTO.EmployeeDTO;
import br.edu.ifbaiano.homines.api.DTO.OrdinanceDTO;
import br.edu.ifbaiano.homines.api.DTO.ProbationaryStageDTO;
import br.edu.ifbaiano.homines.api.DTO.ProgressionDTO;
import br.edu.ifbaiano.homines.api.DTO.VacationDTO;
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
		ProbationaryStageDTO probationaryStageDTO = new ProbationaryStageDTO();
		
		List<Progression> progressions = new ArrayList<>();
		ProgressionDTO progressionDTO = new ProgressionDTO(); 
		
		List<Vacation> vacations = new ArrayList<>();
		VacationDTO vacationDTO = new VacationDTO();
		
		List<Ordinance> ordinances = new ArrayList<>();
		OrdinanceDTO ordinanceDTO = new OrdinanceDTO();
		
		EmployeeDTO employeeDTO = new EmployeeDTO();

		employee = findOrFail(employeeId);
		probationaryStage = probationaryStageRepository.byEmployee(employeeId);
		progressions = progressionRepository.progressionByEmployee(employeeId);
		vacations = vacationRepository.vacationByEmployee(employeeId);
		ordinances = ordinanceRepository.ordinanceByEmployee(employeeId);

		employeeDTO.setName(employee.getName());
		employeeDTO.setSiape(employee.getSiape());
		employeeDTO.setEmail(employee.getEmail());
		
		employeeDTO.setProbationaryStageDTO(probationaryStageDTO);
		employeeDTO.setProgressionDTO(progressionDTO);
		employeeDTO.setVacationDTO(vacationDTO);
		employeeDTO.setOrdinanceDTO(ordinanceDTO);
		
		if((probationaryStage.getFirstAvaliationDateEnd().isAfter(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateBegin().isAfter(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isAfter(LocalDate.now()))
				|| probationaryStage.getFirstAvaliationDateEnd().isEqual(LocalDate.now())) {
			
			employeeDTO.getProbationaryStageDTO().setProbationaryStageAvaliation("1ª Avaliação");
			employeeDTO.getProbationaryStageDTO().setNextAvaliation(probationaryStage.getSecondAvaliationDateBegin().toString());
			
		}else if((probationaryStage.getFirstAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateEnd().isAfter(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isAfter(LocalDate.now()))
				|| probationaryStage.getSecondAvaliationDateEnd().isEqual(LocalDate.now())) {
			
			employeeDTO.getProbationaryStageDTO().setProbationaryStageAvaliation("2ª Avaliação");
			employeeDTO.getProbationaryStageDTO().setNextAvaliation(probationaryStage.getThirdAvaliationDateBegin().toString());
		}else if((probationaryStage.getFirstAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isBefore(LocalDate.now())) 
				|| probationaryStage.getThirdAvaliationDateBegin().isEqual(LocalDate.now())) {
			
			employeeDTO.getProbationaryStageDTO().setProbationaryStageAvaliation("3ª Avaliação");
			employeeDTO.getProbationaryStageDTO().setNextAvaliation(null);
		}

		if(progressions != null) {
			int position = progressions.size();
			employeeDTO.getProgressionDTO().setActualLevel(progressions.get(position-1).getActualLevel());
			employeeDTO.getProgressionDTO().setNextLevel(progressions.get(position-1).getNextLevel());
			employeeDTO.getProgressionDTO().setNextProgressionDate(progressions.get(position-1).getNextProgressionDate());
			employeeDTO.getProgressionDTO().setLastProgressionDate(progressions.get(position-1).getLastProgressionDate());
		}
		
		if(vacations != null) {
			int position = vacations.size();
			employeeDTO.getVacationDTO().setVacationYear(vacations.get(position-1).getYear());
		}

		if(ordinances != null) {
			int position = ordinances.size();
			employeeDTO.getOrdinanceDTO().setOrdinance(ordinances.get(position-1).getOrdinance());
			employeeDTO.getOrdinanceDTO().setOrdinanceDate((ordinances.get(position-1).getDate()));		
			employeeDTO.getOrdinanceDTO().setTotalOrdinances(ordinances.size());			
		}

		return employeeDTO;
	}
}
