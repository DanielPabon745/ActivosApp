package com.activos.activos_fijos.services.impl;

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
public class ActivoServiceImpl implements ActivoService, IMapper<ActivoDTO, ActivoEntity>{

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
	public ActivoDTO aDto(ActivoEntity a) {
		return mapper.map(a, ActivoDTO.class);
	}

	@Override
	public ActivoEntity aEntity(ActivoDTO a) {
		return mapper.map(a, ActivoEntity.class);
	}

	@Override
	public void guardarActivo(ActivoDTO activoDTO) {
		activoRepository.save(aEntity(activoDTO));
	}

	@Override
	public ActivoDTO actualizarActivo(ActivoDTO activoDTO) {
		return aDto(activoRepository.save(aEntity(activoDTO)));
	}

	@Override
	public List<ActivoDTO> consultarPorTipo(String tipo) {
		List<ActivoDTO> dtos = new ArrayList<>();
		for (ActivoEntity entity : activoRepository.findByTipo(tipo)) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public List<ActivoDTO> consultarPorFechaCompra(Date fechaCompra) {
		List<ActivoDTO> dtos = new ArrayList<>();
		for (ActivoEntity entity : activoRepository.findByFechaCompra(fechaCompra)) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public ActivoDTO consultarPorSerial(Integer serial) throws Exception {
		Optional<ActivoEntity> activo = activoRepository.findById(serial);
		if (!activo.isPresent())
			throw new Exception("El activo no existe");
		return aDto(activo.get());
	}

	@Override
	public ActivoDTO actualizarNumeroInterno(ActivoDTO activoDTO) {
		return aDto(activoRepository.save(aEntity(activoDTO)));
	}


}
 