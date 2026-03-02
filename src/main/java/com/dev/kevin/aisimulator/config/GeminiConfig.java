package com.dev.kevin.aisimulator.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public ChatModel chatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey("AIzaSyAPkv6xvi36gHAji8XyxtCj_YzQNAzIBLs")
                .modelName("gemini-2.5-flash")
                .temperature(0.3)
                .build();
    }
}