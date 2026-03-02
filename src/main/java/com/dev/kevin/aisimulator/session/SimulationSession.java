package com.dev.kevin.aisimulator.session;

import java.util.UUID;


public class SimulationSession {

	private final String sessionId;
	private final String Level;
	private int correctAnswers;
	private boolean finished;
	private String lastQuestion;
	
	
	public SimulationSession(String level) {
		
		this.sessionId = UUID.randomUUID().toString();
		this.Level = level;
		this.correctAnswers = 0;
		this.finished = false;
	}


	public String getLastQuestion() {
		return lastQuestion;
	}


	public void setLastQuestion(String lastQuestion) {
		this.lastQuestion = lastQuestion;
	}


	public String getSessionId() {
		return sessionId;
	}


	public String getLevel() {
		return Level;
	}


	public int getCorrectAnswers() {
		return correctAnswers;
	}


	public boolean isFinished() {
		return finished;
	}
	
	
	
	
	
}
