package com.activos.activos_fijos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.activos")
public class ActivosFijosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivosFijosApplication.class, args);
	}

}
