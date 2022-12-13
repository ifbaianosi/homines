package br.edu.ifbaiano.homines.api.DTO;

import java.time.LocalDate;

public class EmployeeDTO {

	
	private String name;
	private String siape;
	private String email;
	private String probationaryStageAvaliation;
	private String nextAvaliation;
	private String actualProgression;
	private String nextProgression;
	private int vacationYear = 0;
	private String ordinance;
	private LocalDate ordinanceDate;
	private int totalOrdinances;
	
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
	public String getProbationaryStageAvaliation() {
		return probationaryStageAvaliation;
	}
	public void setProbationaryStageAvaliation(String probationaryStageAvaliation) {
		this.probationaryStageAvaliation = probationaryStageAvaliation;
	}
	public String getNextAvaliation() {
		return nextAvaliation;
	}
	public void setNextAvaliation(String nextAvaliation) {
		this.nextAvaliation = nextAvaliation;
	}
	public String getActualProgression() {
		return actualProgression;
	}
	public void setActualProgression(String actualProgression) {
		this.actualProgression = actualProgression;
	}
	public String getNextProgression() {
		return nextProgression;
	}
	public void setNextProgression(String nextProgression) {
		this.nextProgression = nextProgression;
	}
	public int getVacationYear() {
		return vacationYear;
	}
	public void setVacationYear(int vacationYear) {
		this.vacationYear = vacationYear;
	}
	public String getOrdinance() {
		return ordinance;
	}
	public void setOrdinance(String ordinance) {
		this.ordinance = ordinance;
	}
	public LocalDate getOrdinancesDate() {
		return ordinanceDate;
	}
	public void setOrdinancesDate(LocalDate ordinancesDate) {
		this.ordinanceDate = ordinancesDate;
	}
	public int getTotalOrdinances() {
		return totalOrdinances;
	}
	public void setTotalOrdinances(int totalOrdinances) {
		this.totalOrdinances = totalOrdinances;
	}
	
}
