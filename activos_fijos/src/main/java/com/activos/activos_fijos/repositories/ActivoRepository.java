package com.activos.activos_fijos.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.activos.activos_fijos.entities.ActivoEntity;

@Repository
public interface ActivoRepository extends CrudRepository<ActivoEntity, Integer>{

	List<ActivoEntity> findByTipo(String tipo);
	
	List<ActivoEntity> findByFechaCompra(Date fechaCompra);
	
}
