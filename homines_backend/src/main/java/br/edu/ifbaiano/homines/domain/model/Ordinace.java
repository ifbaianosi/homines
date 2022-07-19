package br.edu.ifbaiano.homines.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ordinace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrdinances;
	
	private OffsetDateTime date;
	
	private String ordinance;
	
	private String subject;
	
	private String post;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Server server;

	public Long getIdOrdinances() {
		return idOrdinances;
	}

	public void setIdOrdinances(Long idOrdinances) {
		this.idOrdinances = idOrdinances;
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public String getOrdinance() {
		return ordinance;
	}

	public void setOrdinance(String ordinance) {
		this.ordinance = ordinance;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrdinances);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordinace other = (Ordinace) obj;
		return Objects.equals(idOrdinances, other.idOrdinances);
	}
	
	
	
}
