package com.activos.activos_fijos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.dtos.AreaDTO;
import com.activos.activos_fijos.entities.AreaEntity;
import com.activos.activos_fijos.repositories.AreaRepository;
import com.activos.activos_fijos.services.AreaService;
import com.activos.activos_fijos.util.IMapper;

@Service
public class AreaServiceImpl implements AreaService, IMapper<AreaDTO, AreaEntity> {

	@Autowired
	AreaRepository areaRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<AreaDTO> listarAreas() {
		List<AreaDTO> dtos = new ArrayList<>();
		for (AreaEntity entity : areaRepository.findAll()) {
			dtos.add(aDto(entity));
		}
		return dtos;
	}

	@Override
	public AreaDTO aDto(AreaEntity a) {
		return mapper.map(a, AreaDTO.class);
	}

	@Override
	public AreaEntity aEntity(AreaDTO a) {
		return mapper.map(a, AreaEntity.class);
	}

}
