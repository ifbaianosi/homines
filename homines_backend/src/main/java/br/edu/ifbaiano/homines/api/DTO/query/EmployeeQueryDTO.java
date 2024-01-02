package br.edu.ifbaiano.homines.api.DTO.query;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.ifbaiano.homines.domain.model.SituationEnum;

public class EmployeeQueryDTO {
	
	private String name;
	private String siape;
	private String career;
	@Enumerated(EnumType.STRING)
	private SituationEnum situation;
	
	public EmployeeQueryDTO(String name, String siape, String career, SituationEnum situation) {
		this.name = name;
		this.siape = siape;
		this.career = career;
		this.situation = situation;
	}
	
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

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public SituationEnum getSituation() {
		return situation;
	}

	public void setSituation(SituationEnum situation) {
		this.situation = situation;
	}

}
