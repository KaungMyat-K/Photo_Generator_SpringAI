package com.ai.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.services.ChatService;
import com.ai.services.PhotoGenerateService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GenAIController {
    
    @Autowired
    private ChatService chatService;

    @Autowired
    private PhotoGenerateService photoGenerateService;

    @GetMapping("/ask-ai")
    public String getChat(@RequestParam String prompt){
       return chatService.getResponse(prompt);
    }

    @GetMapping("/generate-image")
    public List<String> getGenerateImage(@RequestParam String prompt,HttpServletResponse response) throws IOException{
       ImageResponse imageResponse = photoGenerateService.imageResponse(prompt);
        List<String> imageUrl =imageResponse.getResults().stream()
                    .map(result->result.getOutput().getUrl())
                    .collect(Collectors.toList());
        return imageUrl;    
    }   



}
