package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class LibroDbUtil {

	private DataSource dataSource;
 
	public LibroDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Libro> getLibros() throws Exception {
		
		List<Libro> libros = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			 
			// create sql statement
			String sql = "select * from lista_obras.obras order by estado";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre_obra");
				String tipo = myRs.getString("tipo");
				String genero = myRs.getString("genero");
				String estado = myRs.getString("estado");
				
				// create new student object
				Libro tempLibro = new Libro(id, nombre, tipo, genero,estado);
				
				// add it to the list of students
				libros.add(tempLibro);				
			}
			
			return libros;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
// Try whit resouse 
		
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addLibros(Libro libro) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		 
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into lista_obras.obras "
					   + "(nombre_obra, tipo, genero, estado) "
					   + "values (?, ?, ?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the libros
			myStmt.setString(1, libro.getNombre());
			myStmt.setString(2, libro.getTipo());
			myStmt.setString(3, libro.getGenero());
			myStmt.setString(4, libro.getEstado());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Libro getLibros(String theLibroId) throws Exception {

		Libro libro = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int libroId;
		
		try {
			// convert libros id to int
			libroId = Integer.parseInt(theLibroId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected libros
			String sql = "select * from lista_obras.obras where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, libroId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre_obra");
				String tipo = myRs.getString("tipo");
				String genero = myRs.getString("genero");
				String estado = myRs.getString("estado");
				
				// use the librosID during construction
				libro = new Libro(libroId, nombre, tipo, genero,estado);
			}
			else {
				throw new Exception("No se encontro el libro con el id: " + libroId);
			}				
			
			return libro;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateLibros(Libro libro) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update lista_obras.obras "
						+ "set nombre_obra=?, tipo=?, genero=?, estado=?"
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, libro.getNombre());
			myStmt.setString(2, libro.getTipo());
			myStmt.setString(3, libro.getGenero());
			myStmt.setString(4, libro.getEstado());
			myStmt.setInt(5, libro.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteLibros(String theLibroId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int librosId = Integer.parseInt(theLibroId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete libro
			String sql = "delete from lista_obras.obras where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, librosId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}

