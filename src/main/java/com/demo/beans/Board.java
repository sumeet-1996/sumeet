package com.demo.beans;

import java.util.List;

public class Board {
	private String currentTeam;
	private String gameState;
	private List<Word> words;
	public String getCurrentTeam() {
		return currentTeam;
	}
	public void setCurrentTeam(String currentTeam) {
		this.currentTeam = currentTeam;
	}
	public String getGameState() {
		return gameState;
	}
	public void setGameState(String gameState) {
		this.gameState = gameState;
	}
	public List<Word> getWords() {
		return words;
	}
	public void setWords(List<Word> words) {
		this.words = words;
	}
	@Override
	public String toString() {
		return "Board [currentTeam=" + currentTeam + ", gameState=" + gameState + ", words=" + words + "]";
	}
	
	

}
