package com.unu.proyectoWebGB.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.model.*;

public class AutoresModel {
	
	Connection conexion;
	CallableStatement cs;
	ResultSet rs;
	Statement st;

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
			String sql = "CALL sp_listar_autor()";
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
	
	public int insertarAutor(Autor autor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertar_autor(?,?)";
			conexion =  Conexion.abrirConexion();
			cs = conexion.prepareCall(sql);
			//cs.setInt(1, autor.getIdAutor());
			cs.setString(1, autor.getNombre());
			cs.setString(2, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			conexion= Conexion.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			conexion= Conexion.cerrarConexion();
			return 0;
		}
	}
	
	public int eliminarAutor(int idautor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarAutor(?)";
			conexion =  Conexion.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			filasAfectadas = cs.executeUpdate();
			conexion= Conexion.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			conexion= Conexion.cerrarConexion();
			return 0;
		}

	}
	
	public int modificarAutor(Autor autor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarAutor(?,?,?)";
			conexion =  Conexion.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, autor.getIdAutor());
			//cs.setInt(2, autor.getIdAutor());
			cs.setString(2, autor.getNombre());
			cs.setString(3, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			conexion= Conexion.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			conexion= Conexion.cerrarConexion();
			return 0;
		}
	}
	
	public Autor obtenerAutor(int idautor) throws SQLException {
		try {
			String sql = "CALL sp_obtenerAutor(?)";
			conexion =  Conexion.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			rs = cs.executeQuery();
			if (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				//autor.setCodigoAutor(rs.getString("codigo"));
				autor.setNombre(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				conexion= Conexion.cerrarConexion();
				return autor;
			}
			conexion =  Conexion.abrirConexion();
			return null;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			conexion= Conexion.cerrarConexion();
			return null;
		}
	}
	
	public int totalAutores() throws SQLException {
		try {
			int totalaut = 0;
			String sql = "SELECT COUNT(codigo) as totalaut FROM autor";
			conexion =  Conexion.abrirConexion();
			st = conexion.prepareStatement(sql);
			rs = st.getResultSet();
			while (rs.next()) {
				totalaut = rs.getInt("totalaut");
			}
			return totalaut;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		} finally {
			conexion= Conexion.cerrarConexion();
		}
	}



	


}
