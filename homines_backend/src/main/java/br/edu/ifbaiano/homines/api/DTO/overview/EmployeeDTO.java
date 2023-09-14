package br.edu.ifbaiano.homines.api.DTO.overview;

public class EmployeeDTO {

	
	private String name;
	private String siape;
	private String email;
	private ProbationaryStageDTO probationaryStageDTO;
	private ProgressionDTO progressionDTO;
	private VacationDTO vacationDTO;
	private OrdinanceDTO ordinanceDTO;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSiape() {
		return siape;
	}
	public void setSiape(String siape) {
		this.siape = siape;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProbationaryStageDTO getProbationaryStageDTO() {
		return probationaryStageDTO;
	}
	public void setProbationaryStageDTO(ProbationaryStageDTO probationaryStageDTO) {
		this.probationaryStageDTO = probationaryStageDTO;
	}
	public ProgressionDTO getProgressionDTO() {
		return progressionDTO;
	}
	public void setProgressionDTO(ProgressionDTO progressionDTO) {
		this.progressionDTO = progressionDTO;
	}
	public VacationDTO getVacationDTO() {
		return vacationDTO;
	}
	public void setVacationDTO(VacationDTO vacationDTO) {
		this.vacationDTO = vacationDTO;
	}
	public OrdinanceDTO getOrdinanceDTO() {
		return ordinanceDTO;
	}
	public void setOrdinanceDTO(OrdinanceDTO ordinanceDTO) {
		this.ordinanceDTO = ordinanceDTO;
	}

	
}
