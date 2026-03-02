package com.dev.kevin.aisimulator.service;

import com.dev.kevin.aisimulator.model.ChatMessage;
import com.dev.kevin.aisimulator.model.Feedback;
import com.dev.kevin.aisimulator.model.MessageSender;
import com.dev.kevin.aisimulator.model.TrainingSession;
import com.dev.kevin.aisimulator.session.SessionManager;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final SessionManager sessionManager;

    public TrainingService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Object answer(String sessionId, String sellerAnswer) {

        TrainingSession session = sessionManager.getSession(sessionId);

        session.addMessage(
                new ChatMessage(MessageSender.SELLER, sellerAnswer)
        );

        boolean correct = validateAnswer(sellerAnswer);

        if (!correct) {

            session.markWrongAnswer();

            return new Feedback(
                    false,
                    "Resposta incorreta. Reveja os conceitos do produto.",
                    session.getScore()
            );
        }

        // Agora precisa passar pontos
        int points = 10; // pode evoluir depois conforme dificuldade
        session.markCorrectAnswer(points);

        String nextQuestion = "Pode me explicar melhor esse ponto?";

        session.addMessage(
                new ChatMessage(MessageSender.AI_CLIENT, nextQuestion)
        );

        return session;
    }

    private boolean validateAnswer(String sellerAnswer) {
        return sellerAnswer != null && sellerAnswer.length() > 20;
    }
}