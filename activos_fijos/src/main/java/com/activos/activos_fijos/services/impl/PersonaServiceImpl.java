package com.activos.activos_fijos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.dtos.PersonaDTO;
import com.activos.activos_fijos.entities.PersonaEntity;
import com.activos.activos_fijos.repositories.PersonaRepository;
import com.activos.activos_fijos.services.PersonaService;
import com.activos.activos_fijos.util.IMapper;

@Service
public class PersonaServiceImpl implements PersonaService, IMapper<PersonaDTO, PersonaEntity> {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PersonaRepository personaRepository;

	@Override
	public List<PersonaDTO> listarPersonas() {
		List<PersonaDTO> personas = new ArrayList<>();
		for (PersonaEntity persona : personaRepository.findAll()) {
			personas.add(aDto(persona));
		}
		return personas;
	}

	@Override
	public PersonaDTO aDto(PersonaEntity a) {
		return mapper.map(a, PersonaDTO.class);
	}

	@Override
	public PersonaEntity aEntity(PersonaDTO a) {
		return mapper.map(a, PersonaEntity.class);
	}

}
