package com.example.helpdesktsi.controller;

import com.example.helpdesktsi.model.User;
import com.example.helpdesktsi.service.ChatService;
import com.example.helpdesktsi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;
    private final UserService userService;

    @Autowired
    public ChatController(ChatService chatService,
                          UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostMapping("/ask")
    public String askChat(@RequestBody String question,
                          Principal principal){

        User user = userService.findByUsername(principal.getName());
        return chatService.handleQuestion(question, user);


    }

}
