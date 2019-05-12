package com.activos.activos_fijos.util.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerApp {

	@ExceptionHandler(ArgumentosInvalidosException.class)
	public ResponseEntity<Message> argumentosInvalidosException(HttpServletRequest request,
			ArgumentosInvalidosException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RespuestaVaciaException.class)
	public ResponseEntity<Message> respuestaVaciaException(HttpServletRequest request,
			RespuestaVaciaException e) {
		Message message = new Message(e.getMessage(), HttpStatus.NOT_FOUND.value(),
				request.getRequestURI());
		return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
	}
	
}
