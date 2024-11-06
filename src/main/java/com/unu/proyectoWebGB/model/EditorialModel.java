package com.unu.proyectoWebGB.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.unu.proyectoWebGB.beans.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EditorialModel extends Conexion {

	// Connection con;
	CallableStatement cs;
	ResultSet rs;
	Statement st;

	public List<Editorial> listareditoriales() throws SQLException {

		try {
			List<Editorial> lista = new ArrayList<Editorial>();
			String sql = "CALL sp_ListarEditorial()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();		
			while (rs.next()) {
				Editorial edit= new Editorial();
				edit.setIdeditorial(rs.getInt("ideditorial"));
				edit.setNombre(rs.getString("nombre"));
				edit.setContacto(rs.getString("contacto"));
				edit.setTelefono(rs.getString("telefono"));			
				lista.add(edit);
			}
			this.cerrarConexion();
			return lista;

		} catch (Exception ex) {
			
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return null;
		}

	}
	
	public int insertar(Editorial edit) {
		
		try {
			int filasafectadas=0;
			String sql="CALL sp_InsertarEditorial(?,?,?)";
			this.abrirConexion();						
			cs=conexion.prepareCall(sql);
			cs.setString(1, edit.getNombre());
			cs.setString(2, edit.getContacto());
			cs.setString(3, edit.getTelefono());
			filasafectadas= cs.executeUpdate();
			this.cerrarConexion();	
			return filasafectadas;
		} catch (Exception e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;
		}
		
	}
	
	public int modificar(Editorial edit) {
		try {
			int filasafectadas=0;
			String sql="CALL sp_modificarEditorial(?,?,?,?)";
			this.abrirConexion();						
			cs=conexion.prepareCall(sql);
			cs.setInt(1, edit.getIdeditorial());
			cs.setString(2, edit.getNombre());
			cs.setString(3, edit.getContacto());
			cs.setString(4, edit.getTelefono());
			filasafectadas= cs.executeUpdate();
			this.cerrarConexion();	
			return filasafectadas;
		} catch (Exception e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;
		}
		
	}
	
	public Editorial obtener(int ideditorial) {
		try {
			int filasafectadas=0;
			String sql="CALL sp_obtenerEditorial(?)";
			this.abrirConexion();						
			cs=conexion.prepareCall(sql);
			cs.setInt(1, ideditorial);
			rs= cs.executeQuery();
			
			if(rs.next()) {
				Editorial edit=new Editorial();
				edit.setIdeditorial(rs.getInt("ideditorial"));
				edit.setNombre(rs.getString("nombre"));
				edit.setContacto(rs.getString("contacto"));
				edit.setTelefono(rs.getString("telefono"));
				this.cerrarConexion();
				return edit;		
			}
			this.cerrarConexion();
			return null;									
		} catch (Exception e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return null;
		}
		
	}
	
	
	public void eliminar(int idEditorial) {
		try {
			
			String sql="CALL sp_eliminarEditorial(?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setInt(1,idEditorial);
			rs=cs.executeQuery();
			
			this.cerrarConexion();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No realizo la eliminacion desde el model: "+e.getMessage());
			this.cerrarConexion();
		}
		
	}
	
	
	

}
