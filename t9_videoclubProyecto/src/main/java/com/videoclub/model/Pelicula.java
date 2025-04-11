package com.videoclub.model;

import jakarta.persistence.*;

@Entity
@Table(name="pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="duracion")
	private int duracion;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="year")
	private int year;
	
	
	//CONSTRUCTORES
	public Pelicula(String nombre, int duracion, String genero, int year) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.genero = genero;
		this.year = year;
	}

	public Pelicula() {
		super();
	}

	
	//GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getGenero() {
		return genero;
	}

	public int getYear() {
		return year;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
