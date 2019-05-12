package com.activos.activos_fijos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.activos.activos_fijos.entities.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer>{

}
