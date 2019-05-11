package com.activos.activos_fijos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
public class LocalizacionEntity {

	@Id
	private int idLocalizacion;
	@NonNull
	private String nombre;
	@Nullable
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
