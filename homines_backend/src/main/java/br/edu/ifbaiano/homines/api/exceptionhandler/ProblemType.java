package br.edu.ifbaiano.homines.api.exceptionhandler;

public enum ProblemType {

	ENTITY_NOT_FOUND("Entity not founded."),
	ENTITY_IN_USE("Entity in use."),
	DOMAIN_ERROR("Violation of rules of domain."),
	DADOS_INVALIDOS("Invalid data.");
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	ProblemType(String title) {
		this.title = title;
	}
	
}
