package com.dev.kevin.aisimulator.service;

import com.dev.kevin.aisimulator.ai.ClientQuestionAssistant;
import com.dev.kevin.aisimulator.ai.FeedbackEvaluationAssistant;
import com.dev.kevin.aisimulator.factory.AssistantFactory;
import com.dev.kevin.aisimulator.model.*;
import com.dev.kevin.aisimulator.session.SessionManager;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private final SessionManager sessionManager;
    private final AssistantFactory assistantFactory;

    public SimulationService(SessionManager sessionManager,
                             AssistantFactory assistantFactory) {
        this.sessionManager = sessionManager;
        this.assistantFactory = assistantFactory;
    }

    public TrainingSession startSimulation(DifficultyLevel level) {

        TrainingSession session = sessionManager.createSession(level);

        session.setFocusedProduct("Supernova Rise 2");

        ClientQuestionAssistant questionAssistant =
                assistantFactory.createQuestionAssistant();

        String firstQuestion = questionAssistant.generateQuestion();

        session.addMessage(new ChatMessage(
                MessageSender.AI_CLIENT,
                firstQuestion
        ));

        return session;
    }

    public TrainingSession submitAnswer(String sessionId, String answer) {

        TrainingSession session =
                sessionManager.getSession(sessionId);

        if (session == null) {
            throw new IllegalStateException("Sessão não encontrada.");
        }

        ChatMessage lastQuestion = session.getMessages().stream()
                .filter(m -> m.getSender() == MessageSender.AI_CLIENT)
                .reduce((first, second) -> second)
                .orElseThrow(() ->
                        new IllegalStateException("Pergunta não encontrada.")
                );

        // Salva resposta do vendedor
        session.addMessage(new ChatMessage(
                MessageSender.SELLER,
                answer
        ));

        // 🔥 CONTEXTO FIXO TEMPORÁRIO (SEM REPOSITORY)
        String context = """
    Supernova Rise 2:
    - Focado em estabilidade e conforto.
    - Indicado para rodagens diárias e corridas longas.
    - Entressola Dreamstrike+ com bom equilíbrio entre maciez e responsividade.
    - Não é modelo de competição.
    - Mantém conforto ao longo da quilometragem.
    """;

        FeedbackEvaluationAssistant feedbackAssistant =
                assistantFactory.createFeedbackAssistant();

        String rawFeedback = feedbackAssistant.evaluate(
                context,
                lastQuestion.getContent(),
                answer
        );

        if (rawFeedback == null || rawFeedback.isBlank()) {
            rawFeedback = "NOTA: 0\nFEEDBACK: Não foi possível gerar avaliação.";
        }

        session.addMessage(new ChatMessage(
                MessageSender.AI_FEEDBACK,
                rawFeedback
        ));

        // Nova pergunta
        ClientQuestionAssistant questionAssistant =
                assistantFactory.createQuestionAssistant();

        String nextQuestion = questionAssistant.generateQuestion();

        session.addMessage(new ChatMessage(
                MessageSender.AI_CLIENT,
                nextQuestion
        ));

        return session;
    }
}