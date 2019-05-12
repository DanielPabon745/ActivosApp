package com.activos.activos_fijos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Localizacion")
public class Localizacion {

	@Id
	@ApiModelProperty(value = "Id de la localización", required = true)
	private int idLocalizacion;
	@NonNull
	@ApiModelProperty(value = "Nombre de la localización", required = true)
	private String nombre;
	@Nullable
	@ApiModelProperty(value = "Id de la localización donde pertenece", required = true)
	private Integer ubicacion;

	public int getIdLocalizacion() {
		return idLocalizacion;
	}

	public void setIdLocalizacion(int idLocalizacion) {
		this.idLocalizacion = idLocalizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

}
