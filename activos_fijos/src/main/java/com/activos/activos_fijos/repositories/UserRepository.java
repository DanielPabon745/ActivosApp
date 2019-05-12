package com.activos.activos_fijos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activos.activos_fijos.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);

}
