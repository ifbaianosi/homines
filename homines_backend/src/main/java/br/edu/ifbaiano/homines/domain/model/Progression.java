package br.edu.ifbaiano.homines.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Progression {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String actualLevel;
	
	private String nextLevel;
	
	private OffsetDateTime lastProgressionDate;
	
	private OffsetDateTime nextProgressionDate;
	
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

	public OffsetDateTime getLastProgressionDate() {
		return lastProgressionDate;
	}

	public void setLastProgressionDate(OffsetDateTime lastProgressionDate) {
		this.lastProgressionDate = lastProgressionDate;
	}

	public OffsetDateTime getNextProgressionDate() {
		return nextProgressionDate;
	}

	public void setNextProgressionDate(OffsetDateTime nextProgressionDate) {
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
