package com.rest.proyect.game.dao;

import java.util.List;

import com.rest.proyect.game.entity.Game;

public interface GameDAO {
	public List<Game> findAll();
	
	public Game findById(int Id);
	
	public void save(Game game);
	
	public void deleteById(int Id);
}
