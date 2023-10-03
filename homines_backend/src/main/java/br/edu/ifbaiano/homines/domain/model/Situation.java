package br.edu.ifbaiano.homines.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Situation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private SituationEnum situationEnum;
	
	private LocalDate situationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SituationEnum getSituationEnum() {
		return situationEnum;
	}

	public void setSituationEnum(SituationEnum situationEnum) {
		this.situationEnum = situationEnum;
	}

	public LocalDate getSituationDate() {
		return situationDate;
	}

	public void setSituationDate(LocalDate situationDate) {
		this.situationDate = situationDate;
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
		Situation other = (Situation) obj;
		return Objects.equals(id, other.id);
	}
}
