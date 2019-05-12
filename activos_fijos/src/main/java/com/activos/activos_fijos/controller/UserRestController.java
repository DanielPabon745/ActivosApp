package com.activos.activos_fijos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activos.activos_fijos.dtos.CredencialesDTO;
import com.activos.activos_fijos.dtos.TokenResponseDTO;
import com.activos.activos_fijos.services.UserService;
import com.activos.activos_fijos.util.exceptions.ArgumentosInvalidosException;
import com.activos.activos_fijos.util.exceptions.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("users")
@Api(tags = { "Users Rest Controller" })
@SwaggerDefinition(tags = {
		@Tag(name = "Users Rest Controller", description = "Controlador encargado de las peticiones de token") })
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/auth")
	@ApiOperation(value = "auth", nickname = "Autenticación", notes = "Retorna el token de acceso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in process"),
			@ApiResponse(code = 400, message = "Bad parameters request", response = Message.class),
			@ApiResponse(code = 404, message = "Request not found", response = Message.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Message.class) })
	public ResponseEntity<TokenResponseDTO> login(@RequestBody CredencialesDTO user) throws ArgumentosInvalidosException {
		return new ResponseEntity<TokenResponseDTO>(userService.signIn(user.getUsername(), user.getPassword()), HttpStatus.OK);
	}
}
