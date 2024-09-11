package com.ai.services;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoGenerateService {
    
    @Autowired
    private OpenAiImageModel imageModel;


    // public ImageResponse imageResponse(String prompt){
    //     return imageModel.call(new ImagePrompt(prompt));
    // }

    public ImageResponse imageResponse(String prompt){
        return imageModel.call(
        new ImagePrompt(prompt,
        OpenAiImageOptions.builder()
                .withModel("dall-e-2")
                .withQuality("hd")
                .withN(4)
                .withHeight(1024)
                .withWidth(1024).build())
            );
    }

}
