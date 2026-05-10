package com.example.helpdesktsi.controller;

import com.example.helpdesktsi.dto.SupportTicketDTO;
import com.example.helpdesktsi.model.User;
import com.example.helpdesktsi.service.SupportTicketService;
import com.example.helpdesktsi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final SupportTicketService supportTicketService;
    private final UserService userService;
    @Autowired
    public TicketController(SupportTicketService supportTicketService,
                            UserService userService) {
        this.supportTicketService = supportTicketService;
        this.userService = userService;
    }


    @GetMapping("/get")
    public ResponseEntity<List<SupportTicketDTO>> showTicket(Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<SupportTicketDTO> supportTicketDTOS = supportTicketService.getSupportTicket(user.getId());
        return ResponseEntity.ok(supportTicketDTOS);
    }


}
