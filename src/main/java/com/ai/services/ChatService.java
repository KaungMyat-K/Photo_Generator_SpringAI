package com.ai.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    
    @Autowired
    private ChatModel chatModel;

    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }

}
