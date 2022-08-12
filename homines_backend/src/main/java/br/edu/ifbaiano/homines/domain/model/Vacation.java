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
	
	private LocalDate period1DateBegin;
	
	private LocalDate period1DateEnd;
	
	private LocalDate period2DateBegin;
	
	private LocalDate period2DateEnd;
	
	private LocalDate period3DateBegin;
	
	private LocalDate period3DateEnd;
	
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

	public LocalDate getPeriod1DateBegin() {
		return period1DateBegin;
	}

	public void setPeriod1DateBegin(LocalDate period1DateBegin) {
		this.period1DateBegin = period1DateBegin;
	}

	public LocalDate getPeriod1DateEnd() {
		return period1DateEnd;
	}

	public void setPeriod1DateEnd(LocalDate period1DateEnd) {
		this.period1DateEnd = period1DateEnd;
	}

	public LocalDate getPeriod2DateBegin() {
		return period2DateBegin;
	}

	public void setPeriod2DateBegin(LocalDate period2DateBegin) {
		this.period2DateBegin = period2DateBegin;
	}

	public LocalDate getPeriod2DateEnd() {
		return period2DateEnd;
	}

	public void setPeriod2DateEnd(LocalDate period2DateEnd) {
		this.period2DateEnd = period2DateEnd;
	}

	public LocalDate getPeriod3DateBegin() {
		return period3DateBegin;
	}

	public void setPeriod3DateBegin(LocalDate period3DateBegin) {
		this.period3DateBegin = period3DateBegin;
	}

	public LocalDate getPeriod3DateEnd() {
		return period3DateEnd;
	}

	public void setPeriod3DateEnd(LocalDate period3DateEnd) {
		this.period3DateEnd = period3DateEnd;
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
