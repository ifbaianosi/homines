package br.edu.ifbaiano.homines.domain.model;

public enum InactiveReason {
	
	REMOTION("Remoção"),
	REDISTRIBUTION("Redistribuição"),
	EXONERATION("Exoneração"),
	RESIGNATION("Demissão"),
	RETIRED("Aposentaria"),
	VACANCY("Vacância"),
	DEATH("Óbito");
	
	private String description;

	InactiveReason(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
