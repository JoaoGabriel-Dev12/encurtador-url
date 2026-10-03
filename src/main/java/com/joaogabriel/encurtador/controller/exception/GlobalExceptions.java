package com.joaogabriel.encurtador.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joaogabriel.encurtador.service.exceptions.InvalidFieldsException;
import com.joaogabriel.encurtador.service.exceptions.InvalidPasswordException;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<MessageException> invalidPasswordException(InvalidPasswordException exc){
		MessageException message =  new MessageException(System.currentTimeMillis(), HttpStatus.BAD_REQUEST, 
				"Senha inválida", exc.getMessage());
		
		return ResponseEntity.status(message.status()).body(message);
	}
	
	@ExceptionHandler(InvalidFieldsException.class)
	public ResponseEntity<MessageException> invalidFieldsException(InvalidFieldsException exc){
		MessageException message =  new MessageException(System.currentTimeMillis(), HttpStatus.BAD_REQUEST, 
				"Campos inválidos", exc.getMessage());
		
		return ResponseEntity.status(message.status()).body(message);
	}
}
