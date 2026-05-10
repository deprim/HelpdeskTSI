package com.example.helpdesktsi.intenthandlers;

import com.example.helpdesktsi.model.User;

public interface IntentHandler {
    String getIntentName();
    String handle(User user);
}
