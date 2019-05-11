package com.activos.activos_fijos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivosFijosConfig {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
