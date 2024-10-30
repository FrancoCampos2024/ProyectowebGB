package com.unu.proyectoWebGB.beans;

public class Editorial {
	
	private int ideditorial;
	private String nombre;
	private String contacto;
	private String telefono;
	
	
	
	
	public Editorial() {
		this(0,"","","");
	}

	public Editorial(int ideditorial, String nombre, String contacto, String telefono) {
		super();
		this.ideditorial = ideditorial;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
	}

	public int getIdeditorial() {
		return ideditorial;
	}

	public void setIdeditorial(int ideditorial) {
		this.ideditorial = ideditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}
