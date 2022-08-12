package br.edu.ifbaiano.homines.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Progression {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String actualLevel;
	
	private String nextLevel;
	
	private LocalDate lastProgressionDate;
	
	private LocalDate nextProgressionDate;
	
	@NotBlank
	private String progressionMonth;
	
	@OneToOne
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getProgressionMonth() {
		return progressionMonth;
	}

	public void setProgressionMonth(String progressionMonth) {
		this.progressionMonth = progressionMonth;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Progression other = (Progression) obj;
		return Objects.equals(id, other.id);
	}

}
