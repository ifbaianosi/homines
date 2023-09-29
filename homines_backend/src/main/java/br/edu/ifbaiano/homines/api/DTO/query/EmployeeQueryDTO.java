package br.edu.ifbaiano.homines.api.DTO.query;

public class EmployeeQueryDTO {
	
	private String name;
	private String siape;
	private String career;
	
	public EmployeeQueryDTO(String name, String siape, String career) {
		this.name = name;
		this.siape = siape;
		this.career = career;
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

}
