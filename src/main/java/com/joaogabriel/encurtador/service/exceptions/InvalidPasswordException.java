package com.joaogabriel.encurtador.service.exceptions;

public class InvalidPasswordException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidPasswordException() {
		super("Senha deve ter 7 caracteres ou mais");
	}

}
