package com.jacaranda.miprimeraapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundExceptionv extends RuntimeException {
	public ElementNotFoundExceptionv(String id) {
		super("No se puede encontrar el elemnto con id=" + id);
	}
}
