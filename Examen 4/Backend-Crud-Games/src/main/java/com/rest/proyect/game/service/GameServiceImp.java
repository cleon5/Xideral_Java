package com.rest.proyect.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.proyect.game.dao.GameDAO;
import com.rest.proyect.game.entity.Game;

@Service
public class GameServiceImp implements GameService {

private GameDAO gameDAO;
	
	@Autowired
	public GameServiceImp(GameDAO theGameDAO) {
		gameDAO = theGameDAO;
	}
	
	@Override
	@Transactional
	public List<Game> findAll() {
		return gameDAO.findAll();
	}

	@Override
	@Transactional
	public Game findById(int id) {
		return gameDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Game game) {
		gameDAO.save(game);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		gameDAO.deleteById(id);
	}
}
