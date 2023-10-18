package br.edu.ifbaiano.homines.domain.exception;

public class EntityExistsException extends DomainException{

	private static final long serialVersionUID = 1L;

	public EntityExistsException(String message) {
		super(message);
	}
	
}
