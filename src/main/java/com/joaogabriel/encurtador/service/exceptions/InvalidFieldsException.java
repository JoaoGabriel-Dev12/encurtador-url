package com.joaogabriel.encurtador.service.exceptions;

public class InvalidFieldsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidFieldsException() {
		super("Campos inválidos no corpo da requisição!");
	}
}
