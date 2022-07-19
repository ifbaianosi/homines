package br.edu.ifbaiano.homines.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Server {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServers;
	
	private String name;
	
	private String rg;
	
	private String cpf;
	
	private OffsetDateTime birthday;
	
	private String email;
	
	private String personalEmail;
	
	private String phone;
	
	private String classes;
	
	private int siape;
	
	private String function;
	
	private String degree;
		
	private String stand;
	
	private String sector;
	
	private OffsetDateTime entryDate;
	
	private OffsetDateTime departureDate;
	
	private String substituteOf;
	
	private String post;
	
	private String ordinance;
	
	private String frequency;
	
	private String actualLevel;
	
	private String nextLevel;
	
	private OffsetDateTime lastProgressionDate;
	
	private OffsetDateTime nextProgressionDate;
	
	private String progressionMonth;
	
	private OffsetDateTime firstAvaliationDateBegin;
	
	private OffsetDateTime firstAvaliationDateEnd;
	
	private OffsetDateTime secondAvaliationDateBegin;
	
	private OffsetDateTime secondAvaliationDateEnd;
	
	private OffsetDateTime thirdAvaliationDateBegin;
	
	private OffsetDateTime thirdAvaliationDateEnd;
	

	public Long getIdServers() {
		return idServers;
	}

	public void setIdServers(Long idServers) {
		this.idServers = idServers;
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

	public int getSiape() {
		return siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
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

	public String getOrdinance() {
		return ordinance;
	}

	public void setOrdinance(String ordinance) {
		this.ordinance = ordinance;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
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

	@Override
	public int hashCode() {
		return Objects.hash(idServers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		return Objects.equals(idServers, other.idServers);
	}
	
}
