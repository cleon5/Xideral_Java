package com.libros.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libros.spring.dao.LibroDAO;
import com.libros.spring.entity.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	// need to inject Libro dao
	@Autowired
	@Qualifier("libroDbUtil") //Se conecta en la base de datos de Obras
	//@Qualifier("libroDAOImpl") //Se conecta en la base de datos de libros
	private LibroDAO libroDAO;
	
	@Override
	@Transactional
	public List<Libro> getLibros() {
		return libroDAO.getLibros();
	}

	@Override
	@Transactional
	public void saveLibro(Libro libro) {

		libroDAO.saveLibro(libro);
	}

	@Override
	@Transactional
	public Libro getLibro(int theId) {
		
		return libroDAO.getLibro(theId);
	}

	@Override
	@Transactional
	public void deleteLibro(int theId) {
		
		libroDAO.deleteLibro(theId);
	}
}





