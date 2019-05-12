package com.activos.activos_fijos.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.activos.activos_fijos.entities.Activo;

@Repository
public interface ActivoRepository extends CrudRepository<Activo, Integer>{

	List<Activo> findByTipo(String tipo);
	
	List<Activo> findByFechaCompra(Date fechaCompra);
	
}
