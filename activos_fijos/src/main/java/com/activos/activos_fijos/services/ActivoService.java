package com.activos.activos_fijos.services;

import java.text.ParseException;
import java.util.List;

import com.activos.activos_fijos.dtos.ActivoDTO;
import com.activos.activos_fijos.util.exceptions.ArgumentosInvalidosException;
import com.activos.activos_fijos.util.exceptions.RespuestaVaciaException;

public interface ActivoService {

	public List<ActivoDTO> listarActivos() throws RespuestaVaciaException;

	public ActivoDTO guardarActivo(ActivoDTO activoDTO) throws ArgumentosInvalidosException;

	public ActivoDTO actualizarActivo(ActivoDTO activoDTO) throws ArgumentosInvalidosException;

	public List<ActivoDTO> consultarPorTipo(String tipo) throws ArgumentosInvalidosException, RespuestaVaciaException;

	public List<ActivoDTO> consultarPorFechaCompra(String fechaCompra) throws ParseException, ArgumentosInvalidosException, RespuestaVaciaException;

	public ActivoDTO consultarPorSerial(Integer serial) throws ArgumentosInvalidosException, RespuestaVaciaException;

}


