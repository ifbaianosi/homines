package br.edu.ifbaiano.homines.api.DTO.query;

public class EmployeeQueryDTO {
	
	private String name;
	private String siape;
	
	public EmployeeQueryDTO(String name, String siape) {
		this.name = name;
		this.siape = siape;
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

}
