package com.activos.activos_fijos.services;

import java.util.Date;
import java.util.List;

import com.activos.activos_fijos.dtos.ActivoDTO;

public interface ActivoService {

	public List<ActivoDTO> listarActivos();

	public void guardarActivo(ActivoDTO activoDTO);

	public ActivoDTO actualizarActivo(ActivoDTO activoDTO);

	public List<ActivoDTO> consultarPorTipo(String tipo);

	public List<ActivoDTO> consultarPorFechaCompra(Date fechaCompra);

	public ActivoDTO consultarPorSerial(Integer serial) throws Exception;

	public ActivoDTO actualizarNumeroInterno(ActivoDTO activoDTO);
}


