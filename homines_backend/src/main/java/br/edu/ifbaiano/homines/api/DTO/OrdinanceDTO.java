package br.edu.ifbaiano.homines.api.DTO;

import java.time.LocalDate;

public class OrdinanceDTO {

	private String ordinance;
	private LocalDate ordinanceDate;
	private int totalOrdinances;
	
	public String getOrdinance() {
		return ordinance;
	}
	public void setOrdinance(String ordinance) {
		this.ordinance = ordinance;
	}
	public LocalDate getOrdinanceDate() {
		return ordinanceDate;
	}
	public void setOrdinanceDate(LocalDate ordinanceDate) {
		this.ordinanceDate = ordinanceDate;
	}
	public int getTotalOrdinances() {
		return totalOrdinances;
	}
	public void setTotalOrdinances(int totalOrdinances) {
		this.totalOrdinances = totalOrdinances;
	}
	
	
}
