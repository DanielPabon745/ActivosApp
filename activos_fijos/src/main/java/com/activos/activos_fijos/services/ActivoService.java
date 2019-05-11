package com.activos.activos_fijos.services;

import java.text.ParseException;
import java.util.List;

import com.activos.activos_fijos.dtos.ActivoDTO;

public interface ActivoService {

	public List<ActivoDTO> listarActivos();

	public void guardarActivo(ActivoDTO activoDTO) throws Exception;

	public ActivoDTO actualizarActivo(ActivoDTO activoDTO) throws Exception;

	public List<ActivoDTO> consultarPorTipo(String tipo) throws Exception;

	public List<ActivoDTO> consultarPorFechaCompra(String fechaCompra) throws ParseException;

	public ActivoDTO consultarPorSerial(Integer serial) throws Exception;

}


