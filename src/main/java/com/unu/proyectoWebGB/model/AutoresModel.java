package com.unu.proyectoWebGB.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.model.*;

public class AutoresModel {
	
	Connection conexion;
	CallableStatement cs;
	ResultSet rs;

	/*
	 * public List<Autor>listarAutores(){ ArrayList<Autor>autores= new
	 * ArrayList<>(); autores.add(new Autor(1,"Garcia Marquez","Colombia"));
	 * autores.add(new Autor(2,"Leonardo Campos","Peruana")); autores.add(new
	 * Autor(3,"Borges","Argentina"));
	 * 
	 * return autores;
	 * 
	 * }
	 */

	public List<Autor> listarAutores() throws SQLException {
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "CALL sp_listar_autor"
					+ "()";
			conexion =  Conexion.abrirConexion();
			
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));		
				autor.setNombre(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);
			}
			conexion= Conexion.cerrarConexion();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			conexion= Conexion.cerrarConexion();		
			return null;
		}
	}

}
