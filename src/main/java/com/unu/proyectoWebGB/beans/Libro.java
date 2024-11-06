package com.unu.proyectoWebGB.beans;

public class Libro {
	
	private int idlibro;
	private String nombre;
	private int existencia;
	private float precio;
	
	
	private int idautor;
	private int ideditorial;
	private int idgenero;
	
	
	private String descripcion;
	
	//Para mostrar
	
	private String autor;
	private String editorial;
	private String genero;
	
	
	public Libro() {
		super();
	}


	public int getIdlibro() {
		return idlibro;
	}


	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getExistencia() {
		return existencia;
	}


	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getIdautor() {
		return idautor;
	}


	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}


	public int getIdeditorial() {
		return ideditorial;
	}


	public void setIdeditorial(int ideditorial) {
		this.ideditorial = ideditorial;
	}


	public int getIdgenero() {
		return idgenero;
	}


	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	
	
	
	

}
