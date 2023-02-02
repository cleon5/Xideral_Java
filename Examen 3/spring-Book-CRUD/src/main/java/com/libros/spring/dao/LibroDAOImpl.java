package com.libros.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libros.spring.entity.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO { 

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Libro> getLibros() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Libro> theQuery = 
				currentSession.createQuery("from Libro order by tipo",
						Libro.class);
		
		// execute query and get result list
		List<Libro> libros = theQuery.getResultList();
				
		// return the results		
		return libros;
	}

	@Override
	public void saveLibro(Libro libro) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(libro);
		
	}

	@Override
	public Libro getLibro(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Libro libro = currentSession.get(Libro.class, theId);
		
		return libro;
	}

	@Override
	public void deleteLibro(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Libro where id=:libroId");
		theQuery.setParameter("libroId", theId);
		
		theQuery.executeUpdate();		
	}

}
