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
import com.activos.activos_fijos.util.exceptions.ArgumentosInvalidosException;
import com.activos.activos_fijos.util.exceptions.Message;
import com.activos.activos_fijos.util.exceptions.RespuestaVaciaException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/activos")
@Api(tags = { "Activos Rest Controller" })
@SwaggerDefinition(tags = {
		@Tag(name = "Activos Rest Controller", description = "Controlador encargado de los servicios de consulta, creación y actualización de activos fijos.") })
public class ActivoRestController {

	@Autowired
	private ActivoService activoService;

	@GetMapping("/listar")
	@ApiOperation(value = "listar", nickname = "Consultar todos los activos", notes = "Retorna una lista con todos los activos registrados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<List<ActivoDTO>> listar() throws RespuestaVaciaException {
		return new ResponseEntity<List<ActivoDTO>>(activoService.listarActivos(), HttpStatus.OK);
	}

	@PostMapping("/guardar")
	@ApiOperation(value = "guardar", nickname = "Guardar activo", notes = "Guarda un activo parametrizado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<Message> guardarActivo(
			@ApiParam(name = "activoDTO", value = "Activo a guardar", required = true) @RequestBody ActivoDTO activoDTO)
			throws ArgumentosInvalidosException {
		return activoService.guardarActivo(activoDTO);
	}

	@PutMapping("/actualizar")
	@ApiOperation(value = "actualizar", nickname = "Actualizar activo", notes = "Recibe un los datos a actualizar del activo registrado en la base de datos, es indispensable que se incluya el serial del activo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<ActivoDTO> actualizarActivo(
			@ApiParam(name = "activoDTO", value = "Activo a actualizar", required = true) @RequestBody ActivoDTO activoDTO)
			throws ArgumentosInvalidosException {
		return new ResponseEntity<ActivoDTO>(activoService.actualizarActivo(activoDTO), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-tipo")
	@ApiOperation(value = "buscar-por-tipo", nickname = "Consultar por tipo de activo", notes = "Retorna una lista de activos respecto al tipo que le sea parametrizado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<List<ActivoDTO>> buscarPorTipo(
			@ApiParam(name = "tipo", value = "Tipo de activo", required = true) @RequestParam String tipo)
			throws ArgumentosInvalidosException, RespuestaVaciaException {
		return new ResponseEntity<List<ActivoDTO>>(activoService.consultarPorTipo(tipo), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-fecha")
	@ApiOperation(value = "buscar-por-fecha", nickname = "Consultar activos por fecha de compra", notes = "Retorna una lista de activos cuya fecha de compra coincida con la parametrizada")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<List<ActivoDTO>> buscarPorFechaCompra(
			@ApiParam(name = "fechaCompra", value = "Fecha de la compra del activo", required = true) @RequestParam String fechaCompra)
			throws ParseException, ArgumentosInvalidosException, RespuestaVaciaException {
		return new ResponseEntity<List<ActivoDTO>>(activoService.consultarPorFechaCompra(fechaCompra), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-serial")
	@ApiOperation(value = "buscar-por-serial", nickname = "Consultar activo por serial", notes = "Retorna el activo cuyo id coincida con el parametrizado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<ActivoDTO> buscarPorSerial(
			@ApiParam(name = "serial", value = "Serial del activo", required = true) @RequestParam Integer serial)
			throws ArgumentosInvalidosException, RespuestaVaciaException {
		return new ResponseEntity<ActivoDTO>(activoService.consultarPorSerial(serial), HttpStatus.OK);
	}
}
