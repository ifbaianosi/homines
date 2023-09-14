package br.edu.ifbaiano.homines.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Vacation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate firstPeriodDateBegin;
	
	private LocalDate firstPeriodDateEnd;
	
	private LocalDate secondPeriodDateBegin;
	
	private LocalDate secondPeriodDateEnd;
	
	private LocalDate thirdPeriodDateBegin;
	
	private LocalDate thirdPeriodDateEnd;
	
	@NotNull
	private int year;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFirstPeriodDateBegin() {
		return firstPeriodDateBegin;
	}

	public void setFirstPeriodDateBegin(LocalDate firstPeriodDateBegin) {
		this.firstPeriodDateBegin = firstPeriodDateBegin;
	}

	public LocalDate getFirstPeriodDateEnd() {
		return firstPeriodDateEnd;
	}

	public void setFirstPeriodDateEnd(LocalDate firstPeriodDateEnd) {
		this.firstPeriodDateEnd = firstPeriodDateEnd;
	}

	public LocalDate getSecondPeriodDateBegin() {
		return secondPeriodDateBegin;
	}

	public void setSecondPeriodDateBegin(LocalDate secondPeriodDateBegin) {
		this.secondPeriodDateBegin = secondPeriodDateBegin;
	}

	public LocalDate getSecondPeriodDateEnd() {
		return secondPeriodDateEnd;
	}

	public void setSecondPeriodDateEnd(LocalDate secondPeriodDateEnd) {
		this.secondPeriodDateEnd = secondPeriodDateEnd;
	}

	public LocalDate getThirdPeriodDateBegin() {
		return thirdPeriodDateBegin;
	}

	public void setThirdPeriodDateBegin(LocalDate thirdPeriodDateBegin) {
		this.thirdPeriodDateBegin = thirdPeriodDateBegin;
	}

	public LocalDate getThirdPeriodDateEnd() {
		return thirdPeriodDateEnd;
	}

	public void setThirdPeriodDateEnd(LocalDate thirdPeriodDateEnd) {
		this.thirdPeriodDateEnd = thirdPeriodDateEnd;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
		Vacation other = (Vacation) obj;
		return Objects.equals(id, other.id);
	}
}
