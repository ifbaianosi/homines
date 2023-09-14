package br.edu.ifbaiano.homines.api.DTO.query;

import java.util.List;

public class QueryDTO {

	private List<EmployeeQueryDTO> EmployeeQueryDTO;
	private int tae;
	private int docente;
	private int total;
	
	public List<EmployeeQueryDTO> getEmployeeQueryDTO() {
		return EmployeeQueryDTO;
	}
	public void setEmployeeQueryDTO(List<EmployeeQueryDTO> employeeQueryDTO) {
		EmployeeQueryDTO = employeeQueryDTO;
	}
	public int getTae() {
		return tae;
	}
	public void setTae(int tae) {
		this.tae = tae;
	}
	public int getDocente() {
		return docente;
	}
	public void setDocente(int docente) {
		this.docente = docente;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
