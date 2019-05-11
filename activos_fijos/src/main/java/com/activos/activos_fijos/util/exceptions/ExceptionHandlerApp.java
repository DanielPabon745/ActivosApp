package com.activos.activos_fijos.util.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerApp {

	@ExceptionHandler(ArgumentosInvalidosException.class)
	public ResponseEntity<ErrorMessage> argumentosInvalidosException(HttpServletRequest request,
			ArgumentosInvalidosException e) {
		ErrorMessage message = new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RespuestaVaciaException.class)
	public ResponseEntity<ErrorMessage> respuestaVaciaException(HttpServletRequest request,
			RespuestaVaciaException e) {
		ErrorMessage message = new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND.value(),
				request.getRequestURI());
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
}
