package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.beans.Editorial;
import com.unu.proyectoWebGB.model.EditorialModel;

/**
 * Servlet implementation class EditorialController
 */
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EditorialModel modelo = new EditorialModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditorialController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void proccessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		if (request.getParameter("op") == null) {
			listar(request, response);
			return;
		}

		String operacion = request.getParameter("op");

		switch (operacion) {
		case "listar": {
			listar(request, response);
			break;
		}
		case "nuevo": {
			request.getRequestDispatcher("/editorial/nuevaEditorial.jsp").forward(request, response);
			break;
		}
		case "insertar":{
			insertar(request, response);
			break;
		}
		case "modificar":{
			modificar(request, response);
			break;
		}
		case "obtener":{
			obtener(request, response);
			break;
		}
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		try {
			request.setAttribute("listaEditorial", modelo.listareditoriales());

			Iterator<Editorial> it = modelo.listareditoriales().iterator();

			while (it.hasNext()) {
				Editorial edit = it.next();
				System.out.println(edit.getIdeditorial() + " " + edit.getNombre() + " " + edit.getContacto() + " "
						+ edit.getTelefono());
			}
			request.getRequestDispatcher("/editorial/listaEditorial.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("No se realizo la operacion listar.");
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		try {
			Editorial edit= new Editorial();
			edit.setNombre(request.getParameter("nombre"));
			edit.setContacto(request.getParameter("contacto"));
			edit.setTelefono(request.getParameter("telefono"));
			
			if(modelo.insertar(edit)>0) {
				request.getSession().setAttribute("Exito", "Editorial registrada correctamente.");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}else {
				request.getSession().setAttribute("Fracaso", "Editorial no se registro correctamente.");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");			
			}
			
		} catch (Exception e) {
			System.out.println("No se realizo la operacion insertar.");
		}

	}
	
	private void modificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		try {
			Editorial edit= new Editorial();
			edit.setIdeditorial(Integer.parseInt(request.getParameter("ideditorial")));
			edit.setNombre(request.getParameter("nombre"));
			edit.setContacto(request.getParameter("contacto"));
			edit.setTelefono(request.getParameter("telefono"));
			
			request.setAttribute("editorial",edit);
			
			if(modelo.modificar(edit)>0) {
				request.getSession().setAttribute("Exito", "Editorial editada correctamente.");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}else {
				request.getSession().setAttribute("Fracaso", "Editorial no se edito correctamente.");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");			
			}
			
		} catch (Exception e) {
			System.out.println("No se realizo la operacion editar.");
		}

	}
	
	private void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		try {
			String codigo = request.getParameter("id");

			Editorial editorial = modelo.obtener(Integer.parseInt(codigo));

			System.out.println(editorial.getIdeditorial());
			System.out.println(editorial.getNombre());

			if (editorial != null) {
				request.setAttribute("editorial", editorial);
				request.getRequestDispatcher("/editorial/editarEditorial.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
		} catch (IOException | ServletException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			proccessRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		try {
			proccessRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
