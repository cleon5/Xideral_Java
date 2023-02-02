package com.libros.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libros.spring.entity.Libro;

@Repository
public class LibroDbUtil implements LibroDAO {

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Libro> getLibros() {
	
		
		List<Libro> Libros = new ArrayList<>();

		String sql = "select * from lista_obras.obras order by tipo";
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {
		
			while (myRs.next()) {
				
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre_obra");
				String tipo = myRs.getString("tipo");
				String genero = myRs.getString("genero");
				String estado = myRs.getString("estado");
				// create new student object
				Libro tempLibro = new Libro(id, nombre, tipo, genero, estado);
				
				Libros.add(tempLibro);				
			}
			
			return Libros;		
		}catch (Exception e) {
			e.printStackTrace();
			return Libros;
		}
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
				try {
					if (myRs != null) {
						myRs.close();
					}
					
					if (myStmt != null) {
						myStmt.close();
					}
					
					if (myConn != null) {
						myConn.close();  
					}
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
	
	@Override
	public void saveLibro(Libro libro) {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		 
		try {
			
			//Actualizar
			if(libro.getId() != 0 ) {
				
			
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
			else {
			//Guardar nuevo
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				// clean up JDBC objects
				close(myConn, myStmt, null);
			}		
	}

	@Override
	public Libro getLibro(int theId) {
			Libro libro = null;
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int libroId;
			
			try {
				// convert libros id to int
				libroId = theId;
				
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
				return libro;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				// clean up JDBC objects
				close(myConn, myStmt, myRs);
			}
			return libro;
				
	} 
	
	@Override
	public void deleteLibro(int theId) {
		// TODO Auto-generated method stub

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int librosId = theId;
			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}

}

