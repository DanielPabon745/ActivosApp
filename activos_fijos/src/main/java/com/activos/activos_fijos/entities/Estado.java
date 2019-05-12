package com.activos.activos_fijos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Estado")
public class Estado {

	@Id
	@ApiModelProperty(value = "Id del estado", required = true)
	private int idEstado;
	@NonNull
	@ApiModelProperty(value = "Nombre del estado", required = true)
	private String nombre;
	@Nullable
	@ApiModelProperty(value = "Descripción opcional del estado", required = false)
	private String descripcion;

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
