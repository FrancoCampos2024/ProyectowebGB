package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.unu.proyectoWebGB.beans.Libro;
import com.unu.proyectoWebGB.model.LibroModel;

/**
 * Servlet implementation class LibroController
 */
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	LibroModel modelo = new LibroModel();

	protected void proccessrequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operacion = request.getParameter("op");
		System.out.println(operacion);
		if (operacion == null) {
			listarlibro(request, response);
			return;
		}

		switch (operacion) {
		case "listar": {
			listarlibro(request, response);
			break;
		}
		case "nuevo": {
			System.out.println("Entra aca nuevo");
			listarcombos(request, response);
			break;
		}

		case "insertar": {
			insertar(request, response);
			break;
		}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void listarlibro(HttpServletRequest request, HttpServletResponse response) {
		try {

			request.setAttribute("libros", modelo.listar());

			request.getRequestDispatcher("/libros/listaLibros.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar libros: " + e.getMessage());
		}

	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			
			System.out.println("Valores elegidos por el combo");
			System.out.println(request.getParameter("autor"));
			System.out.println(request.getParameter("editorial"));
			System.out.println(request.getParameter("genero"));
			
			Libro libro= new Libro();
			libro.setNombre(request.getParameter("nombre"));
			libro.setExistencia(Integer.parseInt(request.getParameter("existencia")));
			libro.setPrecio(Float.parseFloat(request.getParameter("precio")));
			libro.setIdautor(Integer.parseInt(request.getParameter("autor")));
			libro.setIdeditorial(Integer.parseInt(request.getParameter("editorial")));
			libro.setIdgenero(Integer.parseInt(request.getParameter("genero")));
			libro.setDescripcion(request.getParameter("descripcion"));
			
			
			if(modelo.insertarlibro(libro)>0) {
					System.out.println("Se inserto correctamente.");
					response.sendRedirect(request.getContextPath()+"/LibroController?op=listar");
			}else {
				System.out.println("No se inserto correctamente.");
				response.sendRedirect(request.getContextPath()+"/LibroController?op=listar");			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar libro desde el controlador: "+e.getMessage());
		}

	}

	private void listarcombos(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setAttribute("listarAutores", modelo.comboautores());
			request.setAttribute("listarEditoriales", modelo.comboEditorial());
			request.setAttribute("listarGeneros", modelo.comboGenero());
			request.getRequestDispatcher("/libros/nuevoLibro.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("No lleno el combo autor, funate, controller" + e.getMessage());
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		proccessrequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		proccessrequest(request, response);
	}

}
