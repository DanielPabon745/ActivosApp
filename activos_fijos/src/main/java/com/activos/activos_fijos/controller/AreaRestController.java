package com.activos.activos_fijos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activos.activos_fijos.dtos.AreaDTO;
import com.activos.activos_fijos.services.AreaService;

@RestController
@RequestMapping("/areas")
public class AreaRestController {

	@Autowired
	private AreaService areaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<AreaDTO>> listarAreas(){
		return new ResponseEntity<List<AreaDTO>>(areaService.listarAreas(), HttpStatus.OK);
	}
}
