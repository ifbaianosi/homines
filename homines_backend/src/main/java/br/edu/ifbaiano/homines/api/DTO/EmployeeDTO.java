package br.edu.ifbaiano.homines.api.DTO;

import java.time.LocalDate;

public class EmployeeDTO {

	
	private String probationaryStageAvaliation;
	private String nextAvaliation;
	private String actualProgression;
	private String nextProgression;
	private int vacationYear = 0;
	private int ordinances = 0;
	private LocalDate ordinancesDate;
	private int totalOrdinances;
	
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
	public int getOrdinances() {
		return ordinances;
	}
	public void setOrdinances(int ordinances) {
		this.ordinances = ordinances;
	}
	public LocalDate getOrdinancesDate() {
		return ordinancesDate;
	}
	public void setOrdinancesDate(LocalDate ordinancesDate) {
		this.ordinancesDate = ordinancesDate;
	}
	public int getTotalOrdinances() {
		return totalOrdinances;
	}
	public void setTotalOrdinances(int totalOrdinances) {
		this.totalOrdinances = totalOrdinances;
	}
}
