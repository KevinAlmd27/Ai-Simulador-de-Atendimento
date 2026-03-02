package com.dev.kevin.aisimulator.model;

public class EvaluationResult {

    private final boolean correct;
    private final String feedback;
    private final int score;

    public EvaluationResult(boolean correct, String feedback, int score) {
        this.correct = correct;
        this.feedback = feedback;
        this.score = score;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getScore() {
        return score;
    }
}
