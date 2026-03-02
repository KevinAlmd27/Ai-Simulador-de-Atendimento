package com.dev.kevin.aisimulator.factory;

import com.dev.kevin.aisimulator.ai.ClientQuestionAssistant;
import com.dev.kevin.aisimulator.ai.FeedbackEvaluationAssistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Component;

@Component
public class AssistantFactory {

    private final ChatModel chatModel;

    public AssistantFactory(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public FeedbackEvaluationAssistant createFeedbackAssistant() {
        return AiServices.create(FeedbackEvaluationAssistant.class, chatModel);
    }

    public ClientQuestionAssistant createQuestionAssistant() {
        return AiServices.create(ClientQuestionAssistant.class, chatModel);
    }
}