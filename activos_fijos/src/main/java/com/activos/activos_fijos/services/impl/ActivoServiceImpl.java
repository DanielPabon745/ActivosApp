package com.activos.activos_fijos.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.dtos.ActivoDTO;
import com.activos.activos_fijos.entities.Activo;
import com.activos.activos_fijos.entities.Area;
import com.activos.activos_fijos.entities.Persona;
import com.activos.activos_fijos.repositories.ActivoRepository;
import com.activos.activos_fijos.repositories.AreaRepository;
import com.activos.activos_fijos.repositories.PersonaRepository;
import com.activos.activos_fijos.services.ActivoService;
import com.activos.activos_fijos.util.IMapper;
import com.activos.activos_fijos.util.exceptions.ArgumentosInvalidosException;
import com.activos.activos_fijos.util.exceptions.Message;
import com.activos.activos_fijos.util.exceptions.RespuestaVaciaException;

@Service
public class ActivoServiceImpl implements ActivoService, IMapper<ActivoDTO, Activo> {
	
	@Autowired
	ActivoRepository activoRepository;
	
	@Autowired
	AreaRepository areaRepository;
	
	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<ActivoDTO> listarActivos() throws RespuestaVaciaException {
		List<ActivoDTO> dtos = new ArrayList<>();
		Iterable<Activo> entities = activoRepository.findAll();
		if (StreamSupport.stream(entities.spliterator(), false).count() == 0)
			throw new RespuestaVaciaException("No se encontraron registros de activos.");
		for (Activo activoEntity : entities) {
			dtos.add(aDto(activoEntity));
		}
		return dtos;
	}

	@Override
	public ResponseEntity<Message> guardarActivo(ActivoDTO activoDTO) throws ArgumentosInvalidosException {
		Optional<Activo> activo = activoRepository.findById(activoDTO.getSerial());
		if (activo.isPresent())
			throw new ArgumentosInvalidosException("Ya existe un registro con el serial ingresado.");
		if (activoDTO.getIdPersona() != null && activoDTO.getIdArea() != null)
			throw new ArgumentosInvalidosException("El activo solo puede asignarse a una persona o a un área, por favor corregir.");
		if (activoDTO.getIdArea() != null)
			validarIdArea(activoDTO.getIdArea());
		if (activoDTO.getIdPersona() != null)
			validarIdPersona(activoDTO.getIdPersona());
		validarParametros(activoDTO);
		aDto(activoRepository.save(aEntity(activoDTO)));
		return new ResponseEntity<Message>(new Message("Activo creado", HttpStatus.OK.value(), ""), HttpStatus.OK);
	}

	@Override
	public ActivoDTO actualizarActivo(ActivoDTO activoDTO) throws ArgumentosInvalidosException {
		Optional<Activo> activo = activoRepository.findById(activoDTO.getSerial());
		if (!activo.isPresent()) {
			throw new ArgumentosInvalidosException("El activo a actualizar no existe en la base de datos.");
		}
		if (activoDTO.getFechaBaja().after(activo.get().getFechaCompra()))
			throw new ArgumentosInvalidosException(
					"La fecha de baja ingresada no puede ser mayor a la fecha de compra del activo.");
		return aDto(activoRepository.save(aEntity(activoDTO)));
	}

	@Override
	public List<ActivoDTO> consultarPorTipo(String tipo) throws ArgumentosInvalidosException, RespuestaVaciaException {
		if (tipo == null || tipo.isEmpty())
			throw new ArgumentosInvalidosException("El parámetro tipo no debe ser nulo o estar vacío.");
		List<ActivoDTO> dtos = new ArrayList<>();
		Iterable<Activo> entities = activoRepository.findByTipo(tipo);
		if (StreamSupport.stream(entities.spliterator(), false).count() == 0)
			throw new RespuestaVaciaException(
					"No hay registros de activos que coincidan con el tipo de activo ingresado.");
		for (Activo entity : entities) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public List<ActivoDTO> consultarPorFechaCompra(String fechaCompra)
			throws ParseException, ArgumentosInvalidosException, RespuestaVaciaException {
		if (fechaCompra == null || fechaCompra.isEmpty())
			throw new ArgumentosInvalidosException("El parámetro fechaCompra no debe ser nulo o estar vacío.");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = format.parse(fechaCompra);
		List<ActivoDTO> dtos = new ArrayList<>();
		Iterable<Activo> entities = activoRepository.findByFechaCompra(fecha);
		if (StreamSupport.stream(entities.spliterator(), false).count() == 0)
			throw new RespuestaVaciaException("No hay registros de activos que coincidan con la fecha ingresada.");
		for (Activo entity : entities) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public ActivoDTO consultarPorSerial(Integer serial) throws ArgumentosInvalidosException, RespuestaVaciaException {
		if (serial == null || serial <= 0)
			throw new ArgumentosInvalidosException("El parámetro serial no debe ser nulo o estar vacío.");
		Optional<Activo> activo = activoRepository.findById(serial);
		if (!activo.isPresent())
			throw new RespuestaVaciaException("No hay registros que coincidan con el serial ingresado.");
		return aDto(activo.get());
	}

	@Override
	public ActivoDTO aDto(Activo a) {
		return mapper.map(a, ActivoDTO.class);
	}

	@Override
	public Activo aEntity(ActivoDTO a) {
		return mapper.map(a, Activo.class);
	}

	private void validarParametros(ActivoDTO activo) throws ArgumentosInvalidosException {
		if (activo == null)
			throw new ArgumentosInvalidosException("El activo no debe ser nulo.");
		if (activo.getAlto() < 0)
			throw new ArgumentosInvalidosException("El campo alto debe ser mayor a cero.");
		if (activo.getAncho() < 0)
			throw new ArgumentosInvalidosException("El campo ancho debe ser mayor a cero.");
		if (activo.getColor() == null || activo.getColor().isEmpty())
			throw new ArgumentosInvalidosException("El campo color no debe ser nulo o estar vacío.");
		if (activo.getEstado() <= 0)
			throw new ArgumentosInvalidosException("Por favor ingrese un estado válido.");
		if (activo.getFechaCompra() == null)
			throw new ArgumentosInvalidosException("El campo fecha de compra no debe ser nulo o estar vacío.");
		if (activo.getLargo() < 0)
			throw new ArgumentosInvalidosException("El campo largo debe ser mayor a cero.");
		if (activo.getNombre() == null || activo.getNombre().isEmpty())
			throw new ArgumentosInvalidosException("El campo nombre no debe ser nulo o estar vacío.");
		if (activo.getNumeroInterno() < 0)
			throw new ArgumentosInvalidosException("El campo numero interno debe ser mayor a 0.");
		if (activo.getPeso() < 0)
			throw new ArgumentosInvalidosException("El campo peso debe ser mayor a cero.");
		if (activo.getSerial() < 0)
			throw new ArgumentosInvalidosException("El campo serial debe ser mayor a cero.");
		if (activo.getTipo() == null || activo.getTipo().isEmpty())
			throw new ArgumentosInvalidosException("El campo tipo no debe ser nulo o estar vacío.");
		if (activo.getValor() < 0)
			throw new ArgumentosInvalidosException("El campo valor debe ser mayor a 0.");
	}
	
	private void validarIdArea(Integer idArea) throws ArgumentosInvalidosException {
		Optional<Area> area = areaRepository.findById(idArea);
		if (!area.isPresent())
			throw new ArgumentosInvalidosException("No existe un área identificada con ese id");
	}
	
	private void validarIdPersona(Integer idPersona) throws ArgumentosInvalidosException {
		Optional<Persona> persona = personaRepository.findById(idPersona);
		if (!persona.isPresent())
			throw new ArgumentosInvalidosException("No existe una persona identificada con ese id");
	}
}
