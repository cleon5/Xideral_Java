package com.libros.spring.service;

import java.util.List;

import com.libros.spring.entity.Libro;

public interface LibroService {

	public List<Libro> getLibros();

	public void saveLibro(Libro libro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
