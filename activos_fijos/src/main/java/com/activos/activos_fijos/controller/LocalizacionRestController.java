package com.activos.activos_fijos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activos.activos_fijos.dtos.LocalizacionDTO;
import com.activos.activos_fijos.services.LocalizacionService;

@RestController
@RequestMapping("/localizacion")
public class LocalizacionRestController {

	@Autowired
	private LocalizacionService localizacionService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<LocalizacionDTO>> listar(){
		return new ResponseEntity<List<LocalizacionDTO>>(localizacionService.listar(), HttpStatus.OK);
	}
}
