package com.activos.activos_fijos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activos.activos_fijos.dtos.PersonaDTO;
import com.activos.activos_fijos.services.PersonaService;
import com.activos.activos_fijos.util.exceptions.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/personas")
@Api(tags = { "Personas Rest Controller" })
@SwaggerDefinition(tags = {
		@Tag(name = "Personas Rest Controller", description = "Controlador encargado de los servicios de consulta de personas.") })
public class PersonaRestController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/listar")
	@ApiOperation(value = "listar", nickname = "Consultar todos las personas", notes = "Retorna una lista con todos las personas registradas")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<List<PersonaDTO>> listarPersonas() {
		return new ResponseEntity<List<PersonaDTO>>(personaService.listarPersonas(), HttpStatus.OK);
	}
}
