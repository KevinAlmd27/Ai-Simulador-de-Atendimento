package com.dev.kevin.aisimulator.model;

public enum DifficultyLevel {

	EASY,
	MEDIUM,
	HARD;
	
	public DifficultyLevel next(){
		 switch (this) {
		
		case EASY: return MEDIUM;
		case MEDIUM: return HARD;
		case HARD: default :return HARD;
		
		
		 }
	}
}
