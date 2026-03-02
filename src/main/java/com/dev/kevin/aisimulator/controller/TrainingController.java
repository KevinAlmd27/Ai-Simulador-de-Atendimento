package com.dev.kevin.aisimulator.controller;

import com.dev.kevin.aisimulator.service.TrainingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/training")
public class TrainingController {
	
	private final TrainingService trainingService;

	public TrainingController(TrainingService trainingService) {
		
		this.trainingService = trainingService;
	}
	
	@PostMapping("/answer")
	public Object answer(@RequestParam String sessionId ,@RequestBody String sellerAnswer) {
		//TODO: process POST request
		
		return trainingService.answer(sessionId ,sellerAnswer);
	}
	
	

}
