package com.dev.kevin.aisimulator.session;

import com.dev.kevin.aisimulator.model.DifficultyLevel;
import com.dev.kevin.aisimulator.model.SessionStatus;
import com.dev.kevin.aisimulator.model.TrainingSession;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionManager {

    private final Map<String, TrainingSession> activeSessions =
            new ConcurrentHashMap<>();

    public TrainingSession createSession(DifficultyLevel difficultyLevel) {

        TrainingSession session =
                new TrainingSession(difficultyLevel);

        activeSessions.put(session.getId(), session);

        return session;
    }

    public TrainingSession getSession(String sessionId) {

        if (sessionId == null || sessionId.isBlank()) {
            throw new IllegalStateException("ID da sessão inválido");
        }

        TrainingSession session =
                activeSessions.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("Sessão não encontrada");
        }

        if (session.getStatus() != SessionStatus.IN_PROGRESS) {
            return session;
        }

        return session;
    }

    // Mantemos esses métodos mas NÃO removemos a sessão automaticamente

    public void finishSession(String sessionId) {

        TrainingSession session =
                activeSessions.get(sessionId);

        if (session != null) {
            session.finish();
        }
    }

    public void failSession(String sessionId) {

        TrainingSession session =
                activeSessions.get(sessionId);

        if (session != null) {
            session.markWrongAnswer();
        }
    }
}
