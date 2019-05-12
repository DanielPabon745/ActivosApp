package com.activos.activos_fijos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.dtos.TokenResponseDTO;
import com.activos.activos_fijos.entities.Usuario;
import com.activos.activos_fijos.repositories.UserRepository;
import com.activos.activos_fijos.security.JWTConfig;
import com.activos.activos_fijos.services.UserService;
import com.activos.activos_fijos.util.exceptions.ArgumentosInvalidosException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private JWTConfig jwt;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public TokenResponseDTO signIn(String username, String password) throws ArgumentosInvalidosException {
		try {
			return jwt.generateToken(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)));
		} catch (AuthenticationException e) {
			throw new ArgumentosInvalidosException("Invalid username/password supplied");
		}
	}

}
