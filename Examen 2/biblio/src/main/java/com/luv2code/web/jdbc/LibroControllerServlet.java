package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class LibroControllerServlet
 */
@WebServlet("/LibroControllerServlet")
public class LibroControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LibroDbUtil libroDbUtil;
	 
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			libroDbUtil = new LibroDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listLibros(request, response); 
				break;
				
			case "ADD":
				addLibros(request, response);
				break;
				
			case "LOAD":
				loadLibros(request, response);
				break;
				
			case "UPDATE":
				updateLibros(request, response);
				break;
			
			case "DELETE":
				deleteLibros(request, response);
				break;
				
			default:
				listLibros(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteLibros(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read libro id from form data
		String theLibroId = request.getParameter("libroId");
		
		// delete libro from database
		libroDbUtil.deleteLibros(theLibroId);
		
		// send them back to "list libros" page
		listLibros(request, response); 
	}

	private void updateLibros(HttpServletRequest request, HttpServletResponse response)
		throws Exception { 

		// read libro info from form data
		int id = Integer.parseInt(request.getParameter("libroId"));
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String genero = request.getParameter("genero");
		String estado = request.getParameter("estado");
		
		// create a new libro object
		Libro libro = new Libro(id, nombre, tipo, genero,estado);
		
		// perform update on database
		libroDbUtil.updateLibros(libro);
		
		// send them back to the "list libros" page
		listLibros(request, response);
		
	}

	private void loadLibros(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read libro id from form data
		String theLibroId = request.getParameter("libroId");
		
		// get libro from database (db util)
		Libro libro = libroDbUtil.getLibros(theLibroId);
		
		// place libro in the request attribute
		request.setAttribute("LIBRO", libro);
		
		// send to jsp page: update-libro-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-libro-form2.jsp");
		dispatcher.forward(request, response);		
	}
	
	private void addLibros(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read libro info from form data
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String genero = request.getParameter("genero");	
		String estado = request.getParameter("estado");
		
		// create a new libro object
		Libro libro = new Libro(nombre, tipo, genero,estado);
		
		// add the libro to the database
		libroDbUtil.addLibros(libro);
				
		// send back to main page (the libro list)
		listLibros(request, response);
	}

	private void listLibros(HttpServletRequest request, HttpServletResponse response) 
		throws Exception { 
 
		// get libros from db util
		List<Libro> libro = libroDbUtil.getLibros(); //Aqui se carga la lista de todos los elementos en la base de datos.
		
		// add libros to the request
		request.setAttribute("LIBRO_LIST", libro);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-libros.jsp");
		dispatcher.forward(request, response);
	}

}
