package com.activos.activos_fijos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.repositories.EstadoRepository;
import com.activos.activos_fijos.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	EstadoRepository estadoRepository;
	
}
 