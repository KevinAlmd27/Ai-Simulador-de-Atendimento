package com.dev.kevin.aisimulator.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TrainingSession {

    private String focusedProduct;

    private SessionStatus status = SessionStatus.IN_PROGRESS;
    private DifficultyLevel difficultyLevel;
    private LocalDateTime startedAt = LocalDateTime.now();
    private final String id = UUID.randomUUID().toString();

    private final List<ChatMessage> history = new ArrayList<>();

    private int correctAnswers = 0;
    private int wrongAnswers = 0;
    private int score = 0;
    private int streak = 0;

    private static final int MAX_ERRORS = 3;

    public TrainingSession(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // ========================
    // CHAT
    // ========================

    public List<ChatMessage> getMessages() {
        return history;
    }

    public void addMessage(ChatMessage message) {
        if (message != null) {
            history.add(message);
        }
    }

    // ========================
    // GAME LOGIC
    // ========================

    public void markCorrectAnswer(int points) {
        correctAnswers++;
        streak++;
        score += points;
    }

    public void markWrongAnswer() {
        wrongAnswers++;
        streak = 0;
        score = Math.max(0, score - 5);

        if (wrongAnswers >= MAX_ERRORS) {
            status = SessionStatus.FAILED;
        }
    }

    public void finish() {
        status = SessionStatus.COMPLETED;
    }

    // ========================
    // GETTERS
    // ========================

    public String getId() {
        return id;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getScore() {
        return score;
    }

    public int getStreak() {
        return streak;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    // ========================
    // PRODUCT FOCUS
    // ========================

    public void setFocusedProduct(String focusedProduct) {
        this.focusedProduct = focusedProduct;
    }

    public String getFocusedProduct() {
        return focusedProduct;
    }
}