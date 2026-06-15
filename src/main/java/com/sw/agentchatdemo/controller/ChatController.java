package com.sw.agentchatdemo.controller;

import com.sw.agentchatdemo.model.ChatRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat")
    public String chat(
            @RequestBody ChatRequest request) {

        return chatClient.prompt()
                .user(request.getMessage())
                .call()
                .content();
    }

}