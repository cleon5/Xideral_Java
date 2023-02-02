package com.libros.spring.dao;

import java.util.List;

import com.libros.spring.entity.Libro;

public interface LibroDAO {

	public List<Libro> getLibros();

	public void saveLibro(Libro Libro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
