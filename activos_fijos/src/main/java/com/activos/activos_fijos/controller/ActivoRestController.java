package com.activos.activos_fijos.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.activos.activos_fijos.dtos.ActivoDTO;
import com.activos.activos_fijos.services.ActivoService;

@RestController
@RequestMapping("/activos")
public class ActivoRestController {

	@Autowired
	private ActivoService activoService;

	@GetMapping("/listar")
	public ResponseEntity<List<ActivoDTO>> listar() {
		return new ResponseEntity<List<ActivoDTO>>(activoService.listarActivos(), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/guardar")
	public ResponseEntity guardarActivo(@RequestBody ActivoDTO activoDTO) throws Exception {
		activoService.guardarActivo(activoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<ActivoDTO> actualizarActivo(@RequestBody ActivoDTO activoDTO) throws Exception {
		return new ResponseEntity<ActivoDTO>(activoService.actualizarActivo(activoDTO), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-tipo")
	public ResponseEntity<List<ActivoDTO>> buscarPorTipo(@RequestParam String tipo) throws Exception {
		return new ResponseEntity<List<ActivoDTO>>(activoService.consultarPorTipo(tipo), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-fecha")
	public ResponseEntity<List<ActivoDTO>> buscarPorFechaCompra(@RequestParam String fechaCompra) throws ParseException {
		return new ResponseEntity<List<ActivoDTO>>(activoService.consultarPorFechaCompra(fechaCompra), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-serial")
	public ResponseEntity<ActivoDTO> buscarPorSerial(@RequestParam Integer serial) throws Exception {
		return new ResponseEntity<ActivoDTO>(activoService.consultarPorSerial(serial), HttpStatus.OK);
	}
}
