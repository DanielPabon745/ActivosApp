package com.activos.activos_fijos.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.dtos.ActivoDTO;
import com.activos.activos_fijos.entities.ActivoEntity;
import com.activos.activos_fijos.repositories.ActivoRepository;
import com.activos.activos_fijos.services.ActivoService;
import com.activos.activos_fijos.util.IMapper;

@Service
public class ActivoServiceImpl implements ActivoService, IMapper<ActivoDTO, ActivoEntity> {

	@Autowired
	ActivoRepository activoRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<ActivoDTO> listarActivos() {
		List<ActivoDTO> dtos = new ArrayList<>();
		for (ActivoEntity activoEntity : activoRepository.findAll()) {
			dtos.add(aDto(activoEntity));
		}
		return dtos;
	}

	@Override
	public void guardarActivo(ActivoDTO activoDTO) throws Exception {
		Optional<ActivoEntity> activo = activoRepository.findById(activoDTO.getSerial());
		if(!activo.isPresent())
			throw new Exception("Ya existe un registro con el serial ingresado");
		validarParametros(activoDTO);
		activoRepository.save(aEntity(activoDTO));
	}

	@Override
	public ActivoDTO actualizarActivo(ActivoDTO activoDTO) throws Exception {
		Optional<ActivoEntity> activo = activoRepository.findById(activoDTO.getSerial());
		if (!activo.isPresent()) {
			throw new Exception("El activo a actualizar no existe en la base de datos");
		}
		return aDto(activoRepository.save(aEntity(activoDTO)));
	}

	@Override
	public List<ActivoDTO> consultarPorTipo(String tipo) throws Exception {
		if (tipo == null || tipo.isEmpty())
			throw new Exception("El parámetro tipo no debe ser nulo o estar vacío");
		List<ActivoDTO> dtos = new ArrayList<>();
		for (ActivoEntity entity : activoRepository.findByTipo(tipo)) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public List<ActivoDTO> consultarPorFechaCompra(String fechaCompra) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = format.parse(fechaCompra);
		List<ActivoDTO> dtos = new ArrayList<>();
		for (ActivoEntity entity : activoRepository.findByFechaCompra(fecha)) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public ActivoDTO consultarPorSerial(Integer serial) throws Exception {
		Optional<ActivoEntity> activo = activoRepository.findById(serial);
		if (!activo.isPresent())
			throw new Exception("No hay registros que coincidan con el serial ingresado");
		return aDto(activo.get());
	}

	@Override
	public ActivoDTO aDto(ActivoEntity a) {
		return mapper.map(a, ActivoDTO.class);
	}

	@Override
	public ActivoEntity aEntity(ActivoDTO a) {
		return mapper.map(a, ActivoEntity.class);
	}

	private void validarParametros(ActivoDTO activo) throws Exception {
		if (activo == null)
			throw new Exception("El activo no debe ser nulo");
		if (activo.getAlto() < 0)
			throw new Exception("El campo alto debe ser mayor a cero");
		if (activo.getAncho() < 0)
			throw new Exception("El campo ancho debe ser mayor a cero");
		if (activo.getColor() == null || activo.getColor().isEmpty())
			throw new Exception("El campo color no debe ser nulo o estar vacío");
		if (activo.getEstado() <= 0)
			throw new Exception("Por favor ingrese un estado válido");// Ingrese un estado válido
		if (activo.getFechaCompra() == null)
			throw new Exception("El campo fecha de compra no debe ser nulo o estar vacío");
		if (activo.getLargo() < 0)
			throw new Exception("El campo largo debe ser mayor a cero");
		if (activo.getNombre() == null || activo.getNombre().isEmpty())
			throw new Exception("El campo nombre no debe ser nulo o estar vacío");
		if (activo.getNumeroInterno() < 0)
			throw new Exception("El campo numero interno debe ser mayor a 0");
		if (activo.getPeso() < 0)
			throw new Exception("El campo peso debe ser mayor a cero");
		if (activo.getSerial() < 0)
			throw new Exception("El campo serial debe ser mayor a cero");
		if (activo.getTipo() == null || activo.getTipo().isEmpty())
			throw new Exception("El campo tipo no debe ser nulo o estar vacío");
		if (activo.getValor() < 0)
			throw new Exception("El campo valor debe ser mayor a 0");
	}
}
