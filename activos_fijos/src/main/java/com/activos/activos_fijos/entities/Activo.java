package com.activos.activos_fijos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Activo")
public class Activo {

	@Id
	@ApiModelProperty(value = "Id del activo", required = true)
	private int serial;
	@NonNull
	@ApiModelProperty(value = "Nombre del activo", required = true)
	private String nombre;
	@NonNull
	@ApiModelProperty(value = "Tipo de activo", required = true)
	private String tipo;
	@Nullable
	@ApiModelProperty(value = "Descripcioón del activo", required = false)
	private String descripcion;
	@NonNull
	@ApiModelProperty(value = "Número interno del activo", required = true)
	private int numeroInterno;
	@NonNull
	@ApiModelProperty(value = "Peso del activo", required = true)
	private int peso;
	@NonNull
	@ApiModelProperty(value = "Alto del activo", required = true)
	private int alto;
	@NonNull
	@ApiModelProperty(value = "Ancho del activo", required = true)
	private int ancho;
	@NonNull
	@ApiModelProperty(value = "Largo del activo", required = true)
	private int largo;
	@NonNull
	@ApiModelProperty(value = "Valor del activo", required = true)
	private int valor;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "Fecha de compra del activo", required = false)
	private Date fechaCompra;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Nullable
	@ApiModelProperty(value = "Fecha de baja del activo", required = false)
	private Date fechaBaja;
	@NonNull
	@ApiModelProperty(value = "Estado actual del activo", required = true)
	private int estado;
	@NonNull
	@ApiModelProperty(value = "Color del activo", required = true)
	private String color;
	@Nullable
	@ApiModelProperty(value = "Área asignada", required = false)
	@OneToOne(optional = true)
	@JoinColumn(name = "idArea", referencedColumnName = "idArea", nullable = true)
	private Area area;
	@Nullable
	@ApiModelProperty(value = "Persona asignada", required = false)
	@OneToOne(optional = true)
	@JoinColumn(name = "idPersona", referencedColumnName = "idPersona", nullable = true)
	private Persona persona;

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(int numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
