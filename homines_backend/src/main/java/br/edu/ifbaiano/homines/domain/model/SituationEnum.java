package br.edu.ifbaiano.homines.domain.model;

public enum SituationEnum {

	SUBSTITUTE("Substituto"),
	TRAINING_LICENSE("Licença Capacitação"),
	PHD_LICENSE("Licença Doutorado"),
	MASTER_LICENSE("Licença Mestrado"),
	PATERNITY_LEAVE("Licença Paternidade"),
	MATERNITY_LEAVE("Licença Maternidade"),
	ILLNESS_LEAVE("Tratamento de Saúde"),
	ASSIGNMENT("Cessão"),
	TECHNICAL_COLLABORATION("Colaboração Técnica"),
	ELECTIVE_MANDATE_LICENSE("Mandato Eletivo"),
	OTHERS("Outros");
	
	private String description;
	
	SituationEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}	
}
