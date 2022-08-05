package br.edu.ifbaiano.homines.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	private String rg;
	
	@NotBlank
	@CPF
	private String cpf;
	
	private OffsetDateTime birthday;
	
	private String email;
	
	private String personalEmail;
	
	private String phone;
	
	private String classes;
	
	@NotBlank
	private String siape;
	
	private String functions;
	
	private String degree;
		
	private String stand;
	
	private String sector;
	
	private OffsetDateTime entryDate;
	
	private OffsetDateTime departureDate;
	
	private String substituteOf;
	
	private String post;
	
	private String frequency;
	
	@Enumerated(EnumType.STRING)
	private Career career;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public OffsetDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(OffsetDateTime birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public OffsetDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(OffsetDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public OffsetDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(OffsetDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public String getSubstituteOf() {
		return substituteOf;
	}

	public void setSubstituteOf(String substituteOf) {
		this.substituteOf = substituteOf;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
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
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	
}
