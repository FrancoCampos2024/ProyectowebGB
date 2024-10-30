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
	
	
	public List<Genero> listar(){
		
		try {
			
			List<Genero> genero= new ArrayList<>();
			
			String sql = "Call sp_listaGenero()"; 
			this.abrirConexion();
			cs= conexion.prepareCall(sql);
			rs=cs.executeQuery();
			
			while(rs.next()) {
				Genero g= new Genero();
				g.setIdgenero(rs.getInt("idgenero"));
				g.setNombre(rs.getString("nombre"));
				g.setDescripcion(rs.getString("descripcion"));
				genero.add(g);				
			}
			this.cerrarConexion();
			return genero;
			
		} catch (Exception e) {
			System.out.println("Error listar genero: "+e.getMessage());
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
	

}
