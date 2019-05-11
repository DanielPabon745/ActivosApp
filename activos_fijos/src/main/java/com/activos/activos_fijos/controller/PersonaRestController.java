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

@RestController
@RequestMapping("/personas")
public class PersonaRestController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<PersonaDTO>> listarPersonas(){
		return new ResponseEntity<List<PersonaDTO>>(personaService.listarPersonas(), HttpStatus.OK);
	}
}
