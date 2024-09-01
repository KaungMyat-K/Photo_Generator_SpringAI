package com.ai.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    
    @Autowired
    private ChatModel chatModel;

    public String getResponse(String prompt){
        var response = chatModel.call(
                    new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                            .withModel("gpt-4o")
                            .withTemperature(0.4F)
                        .build()
                    ));
        return response.getResult().getOutput().getContent();
    }

}
