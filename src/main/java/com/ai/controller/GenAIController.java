package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.services.ChatService;

@RestController
public class GenAIController {
    
    @Autowired
    private ChatService chatService;

    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt){
       return chatService.getResponse(prompt);
    }
}
