package com.joaogabriel.encurtador.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogabriel.encurtador.dtos.request.UserRequest;
import com.joaogabriel.encurtador.dtos.response.UserResponse;
import com.joaogabriel.encurtador.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<UserResponse> salvar(@RequestBody UserRequest request){
		UserResponse userResponse = service.salvar(request);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userResponse.id()).toUri();
		
		return ResponseEntity.created(uri).body(userResponse);
	}
}
