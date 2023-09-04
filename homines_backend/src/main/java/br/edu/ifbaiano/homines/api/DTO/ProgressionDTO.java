package br.edu.ifbaiano.homines.api.DTO;

import java.time.LocalDate;

public class ProgressionDTO {
	
	private String actualLevel;
	
	private String nextLevel;
	
	private LocalDate lastProgressionDate;
	
	private LocalDate nextProgressionDate;

	public String getActualLevel() {
		return actualLevel;
	}

	public void setActualLevel(String actualLevel) {
		this.actualLevel = actualLevel;
	}

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}

	public LocalDate getLastProgressionDate() {
		return lastProgressionDate;
	}

	public void setLastProgressionDate(LocalDate lastProgressionDate) {
		this.lastProgressionDate = lastProgressionDate;
	}

	public LocalDate getNextProgressionDate() {
		return nextProgressionDate;
	}

	public void setNextProgressionDate(LocalDate nextProgressionDate) {
		this.nextProgressionDate = nextProgressionDate;
	}

}
