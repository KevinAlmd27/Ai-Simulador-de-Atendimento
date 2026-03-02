package com.dev.kevin.aisimulator.model;

public class Feedback {

	private boolean approved;
	private String message;
	private int score;
	
	
	public Feedback(boolean approved, String message, int score) {
		
		this.approved = approved;
		this.message = message;
		this.score = score;
	}


	public boolean isApproved() {
		return approved;
	}


	public String getMessage() {
		return message;
	}


	public int getScore() {
		return score;
	}
	
	
	
}
