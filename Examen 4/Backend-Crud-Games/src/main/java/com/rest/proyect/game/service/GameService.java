package com.rest.proyect.game.service;

import java.util.List;

import com.rest.proyect.game.entity.Game;

public interface GameService {
	public List<Game> findAll();
	
	public Game findById(int Id);
	
	public void save(Game game);
	
	public void deleteById(int Id);
}
