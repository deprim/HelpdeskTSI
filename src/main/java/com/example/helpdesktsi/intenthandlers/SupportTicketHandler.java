package com.example.helpdesktsi.intenthandlers;

import com.example.helpdesktsi.model.User;
import org.springframework.stereotype.Component;

@Component
public class SupportTicketHandler implements IntentHandler {


    @Override
    public String getIntentName() {
        return "CREATE_TICKET";
    }

    @Override
    public String handle(User user) {
        return "";
    }
}
