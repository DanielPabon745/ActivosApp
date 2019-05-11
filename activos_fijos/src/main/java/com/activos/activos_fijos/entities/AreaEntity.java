package com.activos.activos_fijos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
public class AreaEntity {

	@Id
	private int idArea;
	@NonNull
	private String nombre;
	@Nullable
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
