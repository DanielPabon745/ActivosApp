package com.activos.activos_fijos.services;

import com.activos.activos_fijos.dtos.TokenResponseDTO;
import com.activos.activos_fijos.entities.Usuario;
import com.activos.activos_fijos.util.exceptions.ArgumentosInvalidosException;

public interface UserService {

	Usuario findByUsername(String username);
	TokenResponseDTO signIn(String username, String password) throws ArgumentosInvalidosException;

}
