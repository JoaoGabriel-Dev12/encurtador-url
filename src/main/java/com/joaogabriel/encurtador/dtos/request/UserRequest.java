package com.joaogabriel.encurtador.dtos.request;

public record UserRequest(
		String username,
		String email,
		String senha
) {}
