package br.edu.ifbaiano.homines.api.exceptionhandler;

public enum ProblemType {

	ENTITY_NOT_FOUND("Entidade não encontrada."),
	ENTITY_IN_USE("Entidade em uso."),
	DOMAIN_ERROR("Violação das regras de domínio."),
	DADOS_INVALIDOS("Dados inválidos");
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	ProblemType(String title) {
		this.title = title;
	}
	
}
