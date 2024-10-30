package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.beans.Genero;
import com.unu.proyectoWebGB.model.GeneroModel;

/**
 * Servlet implementation class GeneroController
 */
public class GeneroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	GeneroModel modelo = new GeneroModel();

	public GeneroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			request.getRequestDispatcher("/generos/nuevoGenero.jsp").forward(request, response);			
			break;
		}
		case "insertar":{
			insertar(request, response);
			break;
		}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void listar(HttpServletRequest request, HttpServletResponse response) {

		try {
			Iterator<Genero> it = modelo.listar().iterator();
			while (it.hasNext()) {
				Genero a = it.next();
				System.out.println(a.getIdgenero() + " " + a.getNombre() + " " + a.getDescripcion());
			}

			request.setAttribute("listaGenero", modelo.listar());
			request.getRequestDispatcher("/generos/listaGenero.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error controlador listar: " + e.getMessage());
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {

		try {
			Genero genero= new Genero();
			
			genero.setNombre(request.getParameter("nombre"));
			genero.setDescripcion(request.getParameter("descripcion"));
			
			if(modelo.insertar(genero)>0) {
				request.getSession().setAttribute("Exito", "Se inserto el genero.");
				response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");
			}else {
				request.getSession().setAttribute("Fracaso", "No se inserto el genero.");
				response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");			
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error insertar genero controlador: "+e.getMessage());
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		proccessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		proccessRequest(request, response);
	}

}