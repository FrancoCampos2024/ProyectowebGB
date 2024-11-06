package com.unu.proyectoWebGB.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unu.proyectoWebGB.beans.Genero;

public class GeneroModel extends Conexion {

	CallableStatement cs;
	ResultSet rs;
	Statement st;

	public List<Genero> listar() {

		try {

			List<Genero> genero = new ArrayList<>();

			String sql = "Call sp_listaGenero()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
				Genero g = new Genero();
				g.setIdgenero(rs.getInt("idgenero"));
				g.setNombre(rs.getString("nombre"));
				g.setDescripcion(rs.getString("descripcion"));
				genero.add(g);
			}
			this.cerrarConexion();
			return genero;

		} catch (Exception e) {
			System.out.println("Error listar genero: " + e.getMessage());
			this.cerrarConexion();
			return null;
		}
	}

	public int insertar(Genero g) {
		try {
			int filasafecta=0;
			String sql="CALL sp_insertarGenero(?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			
			cs.setString(1,g.getNombre());
			cs.setString(2,g.getDescripcion());	
			
			filasafecta=cs.executeUpdate();
			this.cerrarConexion();
			return filasafecta;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en insertar, modelo: "+e.getMessage());
			this.cerrarConexion();
			return 0;
		}
	}

	public Genero obtener(int idgenero) {

		try {

			
			String sql = "CALL sp_obtenerGenero(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idgenero);
			
			rs = cs.executeQuery();

			while (rs.next()) {
				Genero g = new Genero();
				g.setIdgenero(rs.getInt("idgenero"));
				g.setNombre(rs.getString("nombre"));
				g.setDescripcion(rs.getString("descripcion"));
				this.cerrarConexion();
				return g;
			}
			this.cerrarConexion();
			return null;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error obtener genero en modelo: " + e.getMessage());
			this.cerrarConexion();
			return null;
		}
	}
	
	public int modificador(Genero genero) {
		try {
			int filaseliminadas=0;
			String sql="CALL sp_modificarGenero(?,?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setInt(1,genero.getIdgenero());
			cs.setString(2,genero.getNombre());
			cs.setString(3,genero.getDescripcion());
			filaseliminadas=cs.executeUpdate();
			this.cerrarConexion();
			return filaseliminadas;		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modificar desde el modelo: "+ e.getMessage());
			this.cerrarConexion();
			return 0;
		}
	}
	
	public void eliminar(int idgenero) {
		try {
			
			String sql="CALL sp_eliminarGenero(?)";
			this.abrirConexion();			
			cs=conexion.prepareCall(sql);
			cs.setInt(1, idgenero);
			rs=cs.executeQuery();	
			this.cerrarConexion();
			System.out.println("Se elimino el genero correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Genero no se elimino desde el modelo: "+e.getMessage());
			this.cerrarConexion();
		}
		
	}
	
}