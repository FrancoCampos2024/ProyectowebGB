package com.unu.proyectoWebGB.model;

import java.util.*;

import com.unu.proyectoWebGB.beans.Autor;

public class AutoresModel {

	public List<Autor>listarAutores(){
		ArrayList<Autor>autores= new ArrayList<>(); 
		autores.add(new Autor(1,"Garcia Marquez","Colombia"));
		autores.add(new Autor(2,"Leonardo Campos","Peruana"));
		autores.add(new Autor(3,"Borges","Argentina"));
		
		return autores;		
		
	}
}
