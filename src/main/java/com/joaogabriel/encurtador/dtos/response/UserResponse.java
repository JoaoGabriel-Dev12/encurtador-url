package com.joaogabriel.encurtador.dtos.response;

import java.time.OffsetDateTime;

import com.joaogabriel.encurtador.model.enums.StatusUser;

public record UserResponse(
		Long id,
		String username,
		String email,
		String senha,
		OffsetDateTime dataUltimoLogin,
		StatusUser statusUser
) {}
