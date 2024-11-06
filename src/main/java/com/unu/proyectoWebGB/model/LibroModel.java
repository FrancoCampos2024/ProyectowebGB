package com.unu.proyectoWebGB.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.beans.Editorial;
import com.unu.proyectoWebGB.beans.Genero;
import com.unu.proyectoWebGB.beans.Libro;

public class LibroModel extends Conexion {

	CallableStatement cs;
	ResultSet rs;
	Statement st;

	public List<Libro> listar() {
		try {
			List<Libro> libros = new ArrayList<>();
			String sql = "CALL sp_listarLibro()";

			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Libro l = new Libro();
				l.setIdautor(rs.getInt("l.idlibro"));
				l.setNombre(rs.getString("l.nombres"));
				l.setExistencia(rs.getInt("l.existencia"));
				l.setPrecio(rs.getFloat("l.precio"));
				l.setAutor(rs.getString("a.nombre"));
				l.setEditorial(rs.getString("e.nombre"));
				l.setGenero(rs.getString("g.nombre"));
				l.setDescripcion(rs.getString("l.descripcion"));
				libros.add(l);
			}
			this.cerrarConexion();
			return libros;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar desde model: " + e.getMessage());
			this.cerrarConexion();
			return null;
		}

	}
	
	public int insertarlibro(Libro l) {
		
		try {
			int filasafect=0;
			String sql="Call sp_insertarLibro(?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setString(1,l.getNombre());
			cs.setInt(2,l.getExistencia());
			cs.setFloat(3, l.getPrecio());
			cs.setInt(4, l.getIdautor());
			cs.setInt(5, l.getIdeditorial());
			cs.setInt(6, l.getIdgenero());
			cs.setString(7, l.getDescripcion());
			filasafect=cs.executeUpdate();
			this.cerrarConexion();
			return filasafect;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se inserto correctamente: "+e.getMessage());
			this.cerrarConexion();
			return 0;
		}
		
	}
	
	
	
	

	public List<Autor> comboautores() {

		try {

			List<Autor> autores = new ArrayList<>();

			String sql = "select a.idautor,a.nombre from autor a";
			this.abrirConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Autor a= new Autor();
				a.setIdAutor(rs.getInt("a.idautor"));
				a.setNombre(rs.getString("nombre"));
				autores.add(a);				
			}
			this.cerrarConexion();
			return autores;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error, no listo autores en modelo libro: " + e.getMessage());
			this.cerrarConexion();
			return null;
		}
	}

	public List<Editorial> comboEditorial() {
		try {
			String sql = "select e.ideditorial,e.nombre  from editorial e";
			this.abrirConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			List<Editorial> editorial = new ArrayList<>();
			while (rs.next()) {
				Editorial e= new Editorial();
				e.setIdeditorial(rs.getInt("e.ideditorial"));
				e.setNombre(rs.getString("e.nombre"));
				editorial.add(e);				
			}
			this.cerrarConexion();
			return editorial;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error, no listo editorial en modelo libro: " + e.getMessage());
			this.cerrarConexion();
			return null;
		}

	}
	
	public List<Genero> comboGenero() {
		try {
			String sql = "select g.idgenero,g.nombre  from genero g";
			this.abrirConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			List<Genero> genero = new ArrayList<>();
			while (rs.next()) {
				Genero g= new Genero();
				g.setIdgenero(rs.getInt("g.idgenero"));
				g.setNombre(rs.getString("g.nombre"));
				genero.add(g);
				System.out.println(rs.getString("g.nombre"));
			}
			this.cerrarConexion();
			return genero;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error, no listo genero en modelo libro: " + e.getMessage());
			this.cerrarConexion();
			return null;
		}

	}
	
	
	
	/*public void */
	
	

}
