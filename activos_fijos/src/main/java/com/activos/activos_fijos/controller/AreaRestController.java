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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/areas")
@Api(tags = { "Area Rest Controller" })
@SwaggerDefinition(tags = {
		@Tag(name = "Area Rest Controller", description = "Controlador encargado de la consulta de areas.") })
public class AreaRestController {

	@Autowired
	private AreaService areaService;

	@GetMapping("/listar")
	@ApiOperation(value = "listar", nickname = "Consultar Areas", notes = "Retorna una lista con las areas registradas en el aplicativo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request"),
			@ApiResponse(code = 404, message = "Request not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public ResponseEntity<List<AreaDTO>> listarAreas() {
		return new ResponseEntity<List<AreaDTO>>(areaService.listarAreas(), HttpStatus.OK);
	}
}
