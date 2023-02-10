package com.rest.proyect.game.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.proyect.game.entity.Game;

@Repository
public class GameDAOImp implements GameDAO {

	private EntityManager entityManager;
	@Autowired
	public GameDAOImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Game> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Game> theQuery = currentSession.createQuery("from Game", Game.class);
		List<Game> game = theQuery.getResultList();
	
		return game;
	}

	@Override
	public Game findById(int Id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Game game = currentSession.get(Game.class, Id);
		return game;
	}

	@Override
	public void save(Game game) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(game);
		
	}

	@Override
	public void deleteById(int Id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<?> theQuery = currentSession.createQuery("delete from Game where id=:Id");
		theQuery.setParameter("Id", Id);
		
		theQuery.executeUpdate();
		
	}

}
