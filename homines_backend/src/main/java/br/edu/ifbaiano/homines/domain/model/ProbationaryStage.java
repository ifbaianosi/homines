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
public class ProbationaryStage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private OffsetDateTime firstAvaliationDateBegin;
	
	private OffsetDateTime firstAvaliationDateEnd;
	
	private OffsetDateTime secondAvaliationDateBegin;
	
	private OffsetDateTime secondAvaliationDateEnd;
	
	private OffsetDateTime thirdAvaliationDateBegin;
	
	private OffsetDateTime thirdAvaliationDateEnd;
	
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

	public OffsetDateTime getFirstAvaliationDateBegin() {
		return firstAvaliationDateBegin;
	}

	public void setFirstAvaliationDateBegin(OffsetDateTime firstAvaliationDateBegin) {
		this.firstAvaliationDateBegin = firstAvaliationDateBegin;
	}

	public OffsetDateTime getFirstAvaliationDateEnd() {
		return firstAvaliationDateEnd;
	}

	public void setFirstAvaliationDateEnd(OffsetDateTime firstAvaliationDateEnd) {
		this.firstAvaliationDateEnd = firstAvaliationDateEnd;
	}

	public OffsetDateTime getSecondAvaliationDateBegin() {
		return secondAvaliationDateBegin;
	}

	public void setSecondAvaliationDateBegin(OffsetDateTime secondAvaliationDateBegin) {
		this.secondAvaliationDateBegin = secondAvaliationDateBegin;
	}

	public OffsetDateTime getSecondAvaliationDateEnd() {
		return secondAvaliationDateEnd;
	}

	public void setSecondAvaliationDateEnd(OffsetDateTime secondAvaliationDateEnd) {
		this.secondAvaliationDateEnd = secondAvaliationDateEnd;
	}

	public OffsetDateTime getThirdAvaliationDateBegin() {
		return thirdAvaliationDateBegin;
	}

	public void setThirdAvaliationDateBegin(OffsetDateTime thirdAvaliationDateBegin) {
		this.thirdAvaliationDateBegin = thirdAvaliationDateBegin;
	}

	public OffsetDateTime getThirdAvaliationDateEnd() {
		return thirdAvaliationDateEnd;
	}

	public void setThirdAvaliationDateEnd(OffsetDateTime thirdAvaliationDateEnd) {
		this.thirdAvaliationDateEnd = thirdAvaliationDateEnd;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
