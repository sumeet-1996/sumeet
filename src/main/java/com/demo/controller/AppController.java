package com.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Board;
import com.demo.service.ApplicationService;

@RestController
public class AppController {
	
	private ApplicationService service = new ApplicationService();
	
	@RequestMapping(value="/board", method= RequestMethod.GET)
	public Board getBoard() {
		return service.fetchBoard();
	}
	
	@RequestMapping(value="/words/{gameState}/{currentTeam}/{index}", method= RequestMethod.GET)
	public void updateWords(@PathVariable String gameState, @PathVariable String currentTeam, @PathVariable int index) {
		service.updateWord(gameState, currentTeam, index);
	}
	
	@RequestMapping(value="/newGame", method= RequestMethod.GET)
	public Board startNewGame() {
		return service.startNewGame();
	}
}
