package com.activos.activos_fijos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Area")
public class Area {

	@Id
	@ApiModelProperty(value = "Id del área", required = true)
	private Integer idArea;
	@NonNull
	@ApiModelProperty(value = "Nombre del área", required = true)
	private String nombre;
	@NonNull
	@ApiModelProperty(value = "Id de localización del área", required = true)
	private Integer idLocalizacion;
	

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdLocalizacion() {
		return idLocalizacion;
	}

	public void setIdLocalizacion(Integer idLocalizacion) {
		this.idLocalizacion = idLocalizacion;
	}

}
