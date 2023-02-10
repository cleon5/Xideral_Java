package com.rest.proyect.game.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.proyect.game.entity.Game;
import com.rest.proyect.game.service.GameService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api")
public class GameController {
	private GameService gameService;
	
	@Autowired
	public GameController(GameService contacService) {
		gameService = contacService;
	}
	
	@GetMapping("/games")
	public List<Game> findAll() {
		return gameService.findAll();
	}

	@GetMapping("/games/{gameId}")
	public Game getGame(@PathVariable int gameId) {		
		Game theGame = gameService.findById(gameId);
		
		if (theGame == null) 
			throw new GameNotFoundException("Videojuego no encontrado - " + gameId);
		
		return theGame;
	}

	
	@PostMapping("/games")
	public Game addGame(@RequestBody Game game) {
		game.setId(0);
		gameService.save(game);
		return game;
	}
	
	@PutMapping("/games")
	public Game updateGame(@RequestBody Game game) {
		gameService.save(game);
		
		return game;
	}
	
	@DeleteMapping("/games/{gameId}")
	public String deleteGame(@PathVariable int gameId) {
		
		Game tempGame = gameService.findById(gameId);
		
		if (tempGame == null) 
			throw new GameNotFoundException("Videojuego no encontrado - " + gameId);

		gameService.deleteById(gameId);
		return "Videojuego borrado - " + gameId;
	}
}
