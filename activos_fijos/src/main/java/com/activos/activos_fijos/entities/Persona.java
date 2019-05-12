package com.activos.activos_fijos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Persona")
public class Persona {

	@Id
	@ApiModelProperty(value = "Id de la persona", required = true)
	private int idPersona;
	@NonNull
	@ApiModelProperty(value = "Primer nombre de la persona", required = true)
	private String primerNombre;
	@Nullable
	@ApiModelProperty(value = "Segundo nombre de la persona", required = false)
	private String segundoNombre;
	@NonNull
	@ApiModelProperty(value = "Primer apellido de la persona", required = true)
	private String primerApellido;
	@NonNull
	@ApiModelProperty(value = "Segundo apellido de la persona", required = true)
	private String segundoApellido;
	@NonNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "Fecha de nacimiento de la persona", required = true)
	private Date fechaNacimiento;
	@NonNull
	@ApiModelProperty(value = "Cargo actual de la persona", required = true)
	private String cargo;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
