package br.edu.ifbaiano.homines.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifbaiano.homines.api.DTO.overview.EmployeeDTO;
import br.edu.ifbaiano.homines.api.DTO.overview.OrdinanceDTO;
import br.edu.ifbaiano.homines.api.DTO.overview.ProbationaryStageDTO;
import br.edu.ifbaiano.homines.api.DTO.overview.ProgressionDTO;
import br.edu.ifbaiano.homines.api.DTO.overview.VacationDTO;
import br.edu.ifbaiano.homines.domain.exception.EntityNotFoundException;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.Ordinance;
import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;
import br.edu.ifbaiano.homines.domain.model.Progression;
import br.edu.ifbaiano.homines.domain.model.Situation;
import br.edu.ifbaiano.homines.domain.model.Vacation;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepository;
import br.edu.ifbaiano.homines.domain.repository.OrdinanceRepository;
import br.edu.ifbaiano.homines.domain.repository.ProbationaryStageRepository;
import br.edu.ifbaiano.homines.domain.repository.ProgressionRepository;
import br.edu.ifbaiano.homines.domain.repository.SituationRepository;
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

	@Autowired
	private SituationRepository situationRepository;
	
	
	public Employee create(Employee employee) {
		if(employee.getSituation() != null) {
			situationRepository.save(employee.getSituation());
		}		
		return employeeRepository.save(employee);
	}
	
	@Transactional
	public Employee update(Employee employee, Long employeeId) {
		Situation situation = null;
		
		if(employee.getSituation() != null) {
		situation = situationRepository.save(employee.getSituation());
		}
		
		Employee employeeFromBD = employeeRepository.lookEmployee(employeeId);
		System.out.println("----------------->"+employeeFromBD);
		BeanUtils.copyProperties(employee, employeeFromBD, "id");
		employeeFromBD.setSituation(situation);
		employeeFromBD = employeeRepository.save(employeeFromBD);
				
		return employeeFromBD;
	}
	
	@Transactional
	public void delete(Long employeeId) {
		Employee employee = findOrFail(employeeId);
		employeeRepository.delete(employee);
		employeeRepository.flush();

	}

	public Employee findOrFail(Long employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException(
				String.format("Employee with id %d was not founded.", employeeId)));
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
		
		probationaryStageDTO = verifyAvaliation(probationaryStage);

		employeeDTO.setName(employee.getName());
		employeeDTO.setSiape(employee.getSiape());
		employeeDTO.setEmail(employee.getEmail());
		
		employeeDTO.setProbationaryStageDTO(probationaryStageDTO);
		employeeDTO.setProgressionDTO(progressionDTO);
		employeeDTO.setVacationDTO(vacationDTO);
		employeeDTO.setOrdinanceDTO(ordinanceDTO);
		
		employeeDTO.getProbationaryStageDTO().setProbationaryStageAvaliation(probationaryStageDTO.getProbationaryStageAvaliation());
		employeeDTO.getProbationaryStageDTO().setNextAvaliation(probationaryStageDTO.getNextAvaliation());
		
		if(!progressions.isEmpty()) {
			int position = progressions.size();
			employeeDTO.getProgressionDTO().setActualLevel(progressions.get(position-1).getActualLevel());
			employeeDTO.getProgressionDTO().setNextLevel(progressions.get(position-1).getNextLevel());
			employeeDTO.getProgressionDTO().setNextProgressionDate(progressions.get(position-1).getNextProgressionDate());
			employeeDTO.getProgressionDTO().setLastProgressionDate(progressions.get(position-1).getLastProgressionDate());
		}
		
		if(!vacations.isEmpty()) {
			int position = vacations.size();
			employeeDTO.getVacationDTO().setVacationYear(vacations.get(position-1).getYear());
		}

		if(!ordinances.isEmpty()) {
			int position = ordinances.size();
			employeeDTO.getOrdinanceDTO().setOrdinance(ordinances.get(position-1).getOrdinance());
			employeeDTO.getOrdinanceDTO().setOrdinanceDate((ordinances.get(position-1).getDate()));		
			employeeDTO.getOrdinanceDTO().setTotalOrdinances(ordinances.size());			
		}

		return employeeDTO;
	}
	
	public ProbationaryStageDTO verifyAvaliation(ProbationaryStage probationaryStage) {
		
		ProbationaryStageDTO probationaryStageDTO = new ProbationaryStageDTO();

		
		if((probationaryStage.getFirstAvaliationDateEnd().isAfter(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateBegin().isAfter(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isAfter(LocalDate.now()))
				|| probationaryStage.getFirstAvaliationDateEnd().isEqual(LocalDate.now())) {
			
			probationaryStageDTO.setProbationaryStageAvaliation("1ª Avaliação");
			probationaryStageDTO.setNextAvaliation(probationaryStage.getSecondAvaliationDateBegin().toString());
			probationaryStageDTO.setAvaliation(1);
			probationaryStageDTO.setSituationFinished(false);
			
		}else if((probationaryStage.getFirstAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateEnd().isAfter(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isAfter(LocalDate.now()))
				|| probationaryStage.getSecondAvaliationDateEnd().isEqual(LocalDate.now())) {
			
			probationaryStageDTO.setProbationaryStageAvaliation("2ª Avaliação");
			probationaryStageDTO.setNextAvaliation(probationaryStage.getThirdAvaliationDateBegin().toString());
			probationaryStageDTO.setAvaliation(2);
			probationaryStageDTO.setSituationFinished(false);
			
		}else if((probationaryStage.getFirstAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getSecondAvaliationDateEnd().isBefore(LocalDate.now())
				&& probationaryStage.getThirdAvaliationDateBegin().isBefore(LocalDate.now())) 
				&& (probationaryStage.getThirdAvaliationDateBegin().isEqual(LocalDate.now())
				|| probationaryStage.getThirdAvaliationDateEnd().isAfter(LocalDate.now()))) {
			
			probationaryStageDTO.setProbationaryStageAvaliation("3ª Avaliação");
			probationaryStageDTO.setNextAvaliation(null);
			probationaryStageDTO.setAvaliation(3);
			probationaryStageDTO.setSituationFinished(false);
		}else {
			probationaryStageDTO.setProbationaryStageAvaliation("3ª Avaliação");
			probationaryStageDTO.setNextAvaliation(null);
			probationaryStageDTO.setAvaliation(3);
			probationaryStageDTO.setSituationFinished(true);
		}

		
		return probationaryStageDTO;
	}
}
