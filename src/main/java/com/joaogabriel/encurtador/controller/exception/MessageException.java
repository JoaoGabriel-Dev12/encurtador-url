package com.joaogabriel.encurtador.controller.exception;

import org.springframework.http.HttpStatus;

public record MessageException(long timestamp, HttpStatus status, String error, String message) {

}
