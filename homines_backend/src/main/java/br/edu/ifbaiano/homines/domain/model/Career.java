package br.edu.ifbaiano.homines.domain.model;

public enum Career {

	TAE("TAE"),
	DOCENT("Docente"),
	SUBSTITUTE("Professor Substituto");
	
	private String description;
	
	Career(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
