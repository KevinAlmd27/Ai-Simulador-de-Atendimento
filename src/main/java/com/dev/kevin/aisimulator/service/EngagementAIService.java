package com.dev.kevin.aisimulator.service;

import org.springframework.stereotype.Service;

@Service
public class EngagementAIService {

	public String simulateCustomer(String approach) {
		
		if(approach == null || approach.isBlank()) {
			return "Cliente: estou só dando uma olhada.";
		}
		
		if(approach.toLowerCase().contains("corrida")) {
			return "Cliente: Corro 5 vezes na semana e preciso de um tenis confortavel.";
		
		}
		
		if(approach.toLowerCase().contains("casual")) {
			return "Cliente : quero algo estiloso para o dia dia.";
		}
		
		return "Cliente : pode me explicar melhor esse produto?";
	}
	
}
