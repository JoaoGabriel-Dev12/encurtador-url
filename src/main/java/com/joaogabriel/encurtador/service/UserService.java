package com.joaogabriel.encurtador.service;

import org.springframework.stereotype.Service;

import com.joaogabriel.encurtador.dtos.request.UserRequest;
import com.joaogabriel.encurtador.dtos.response.UserResponse;
import com.joaogabriel.encurtador.model.User;
import com.joaogabriel.encurtador.repository.UserRepository;
import com.joaogabriel.encurtador.service.exceptions.InvalidFieldsException;
import com.joaogabriel.encurtador.service.exceptions.InvalidPasswordException;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserResponse salvar(UserRequest request) {
		if(camposEstaoNulos(request)) {
			throw new InvalidFieldsException();
		}
		
		if (camposEstaoEmBranco(request)) {
			throw new InvalidFieldsException();
		}
		
		if(!senhaEstaValida(request.senha())) {
			throw new InvalidPasswordException();
		}
		
		String senhaCriptografada = criptografarSenha(request.senha());
		User user = new User(request);
		user.setSenha(senhaCriptografada);
		
		user = userRepository.save(user);
		
		return toResponse(user);
	}
	
	private String criptografarSenha(String senha) {
		return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
	}
	
	private boolean camposEstaoNulos(UserRequest request) {
		return request.username() == null || request.email() == null
                || request.senha() == null;
	}
	
	private boolean camposEstaoEmBranco(UserRequest request) {
		return request.username().isBlank() || request.email().isBlank()
				|| request.senha().isBlank();
	}
	
	private boolean senhaEstaValida(String senhaValidar) {
		return senhaValidar.length() >= 7;
	}
	
	private UserResponse toResponse(User user) {
		return new UserResponse(user.getId(), user.getUsename(), user.getEmail(), 
				user.getSenha(), user.getDataUltimoLogin(), user.getStatus());
	}
}
