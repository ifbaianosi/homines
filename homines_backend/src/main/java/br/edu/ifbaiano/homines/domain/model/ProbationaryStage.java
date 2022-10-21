package br.edu.ifbaiano.homines.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ProbationaryStage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate firstAvaliationDateBegin;
	
	private LocalDate firstAvaliationDateEnd;
	
	private LocalDate secondAvaliationDateBegin;
	
	private LocalDate secondAvaliationDateEnd;
	
	private LocalDate thirdAvaliationDateBegin;
	
	private LocalDate thirdAvaliationDateEnd;
	
	@OneToOne
	private Employee employee;

	public Long getId() {
		return id;
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
		ProbationaryStage other = (ProbationaryStage) obj;
		return Objects.equals(id, other.id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFirstAvaliationDateBegin() {
		return firstAvaliationDateBegin;
	}

	public void setFirstAvaliationDateBegin(LocalDate firstAvaliationDateBegin) {
		this.firstAvaliationDateBegin = firstAvaliationDateBegin;
	}

	public LocalDate getFirstAvaliationDateEnd() {
		return firstAvaliationDateEnd;
	}

	public void setFirstAvaliationDateEnd(LocalDate firstAvaliationDateEnd) {
		this.firstAvaliationDateEnd = firstAvaliationDateEnd;
	}

	public LocalDate getSecondAvaliationDateBegin() {
		return secondAvaliationDateBegin;
	}

	public void setSecondAvaliationDateBegin(LocalDate secondAvaliationDateBegin) {
		this.secondAvaliationDateBegin = secondAvaliationDateBegin;
	}

	public LocalDate getSecondAvaliationDateEnd() {
		return secondAvaliationDateEnd;
	}

	public void setSecondAvaliationDateEnd(LocalDate secondAvaliationDateEnd) {
		this.secondAvaliationDateEnd = secondAvaliationDateEnd;
	}

	public LocalDate getThirdAvaliationDateBegin() {
		return thirdAvaliationDateBegin;
	}

	public void setThirdAvaliationDateBegin(LocalDate thirdAvaliationDateBegin) {
		this.thirdAvaliationDateBegin = thirdAvaliationDateBegin;
	}

	public LocalDate getThirdAvaliationDateEnd() {
		return thirdAvaliationDateEnd;
	}

	public void setThirdAvaliationDateEnd(LocalDate thirdAvaliationDateEnd) {
		this.thirdAvaliationDateEnd = thirdAvaliationDateEnd;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
