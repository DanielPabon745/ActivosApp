package com.activos.activos_fijos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.dtos.LocalizacionDTO;
import com.activos.activos_fijos.entities.LocalizacionEntity;
import com.activos.activos_fijos.repositories.LocalizacionRepository;
import com.activos.activos_fijos.services.LocalizacionService;
import com.activos.activos_fijos.util.IMapper;

@Service
public class LocalizacionServiceImpl implements LocalizacionService, IMapper<LocalizacionDTO, LocalizacionEntity>{

	@Autowired
	LocalizacionRepository localizacionRepository;
	
	@Autowired
	ModelMapper mapper;
	
	public List<LocalizacionDTO> listar() {
		List<LocalizacionDTO> dtos = new ArrayList<>();
		for (LocalizacionEntity localizacionEntity : localizacionRepository.findAll()) {
			dtos.add(aDto(localizacionEntity));
		}
		return dtos;
	}

	@Override
	public LocalizacionDTO aDto(LocalizacionEntity a) {
		LocalizacionDTO dto = mapper.map(a, LocalizacionDTO.class);
		return dto;
	}

	@Override
	public LocalizacionEntity aEntity(LocalizacionDTO a) {
		LocalizacionEntity entity = mapper.map(a, LocalizacionEntity.class);
		return entity;
	}
	
}
 