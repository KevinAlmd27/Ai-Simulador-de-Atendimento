package com.dev.kevin.aisimulator.controller;

import com.dev.kevin.aisimulator.model.DifficultyLevel;
import com.dev.kevin.aisimulator.model.TrainingSession;
import com.dev.kevin.aisimulator.service.SimulationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/simulator")
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping
    public String startSimulation(Model model) {

        TrainingSession trainingSession =
                simulationService.startSimulation(DifficultyLevel.EASY);

        model.addAttribute("trainingSession", trainingSession);

        return "simulator";
    }

    @PostMapping
    public String submitAnswer(@RequestParam String sessionId,
                               @RequestParam String answer,
                               Model model) {

        TrainingSession trainingSession =
                simulationService.submitAnswer(sessionId, answer);

        model.addAttribute("trainingSession", trainingSession);

        return "simulator";
    }
}