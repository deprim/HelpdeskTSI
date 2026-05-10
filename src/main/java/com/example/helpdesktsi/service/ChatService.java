package com.example.helpdesktsi.service;

import com.example.helpdesktsi.dto.SupportTicketDTO;
import com.example.helpdesktsi.dto.TicketResponse;
import com.example.helpdesktsi.intenthandlers.IntentHandler;
import com.example.helpdesktsi.mapper.SupportTicketMapper;
import com.example.helpdesktsi.model.SupportTicket;
import com.example.helpdesktsi.model.User;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final Map<String, IntentHandler> handlers;

    @Value("classpath:/prompts/helpdesk-tsi.st")
    private Resource systemPrompt;

    @Value("classpath:/prompts/final-response.st")
    private Resource finalPrompt;

    @Value("classpath:/prompts/create-ticket.st")
    private Resource createTicketPrompt;


    private final SupportTicketMapper supportTicketMapper;
    private final SupportTicketService supportTicketService;






    @Autowired
    public ChatService(ChatClient.Builder chatClientBuilder,
                       List<IntentHandler> handlerList,
                       SupportTicketMapper supportTicketMapper,
                       SupportTicketService supportTicketService) throws IOException {
        this.chatClient = chatClientBuilder.build();
        this.handlers = handlerList.stream()
                .collect(Collectors.toMap(IntentHandler::getIntentName, h -> h));
        this.supportTicketMapper = supportTicketMapper;
        this.supportTicketService = supportTicketService;
    }

    public String getIntent(String question) {
        String response =  this.chatClient.prompt()
                .system(systemPrompt)
                .user(question)
                .call()
                .content();

        return response;

        }

    public String handleQuestion(String question, User user) {


        // llm detects intent
        String intent = getIntent(question);
        System.out.println(intent);

        if("CREATE_TICKET".equals(intent)){

           createTicket(user, question);
           return "Ticket created successfully!";

        }

        IntentHandler handler = handlers.get(intent);
        if (handler == null) {
            return "Sorry, I couldn't understand your request. Please try rephrasing.";
        }

        System.out.println(handler.getIntentName()); // for logging purposes

        Object dto = handler.handle(user);


        return getResponse(dto.toString(), question, intent);
    }

    public String getResponse(Object dto,
                              String question,
                              String intent){

        System.out.println(dto); // for logging purposes

        String finalQuestion = dto + "\n" +
                question + "\n" +
                "Current time is: " + LocalDateTime.now();

        System.out.println(finalQuestion); // for logging purposes

        String response =  this.chatClient.prompt()
                .system(finalPrompt)
                .user(finalQuestion)
                .call()
                .content();

        return response;

    }

    public void createTicket(User user, String question){

        SupportTicketDTO llmDto = this.chatClient.prompt()
                .system(createTicketPrompt)
                .user(question)
                .call()
                .entity(SupportTicketDTO.class);

        SupportTicket supportTicket = supportTicketMapper.toEntity(llmDto);
        supportTicket.setUser(user);
        supportTicket.setResolvedAt(null);
        supportTicketService.createSupportTicket(supportTicket);

    }


}





