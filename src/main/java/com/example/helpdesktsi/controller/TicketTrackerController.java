package com.example.helpdesktsi.controller;

import com.example.helpdesktsi.dto.SupportTicketDTO;
import com.example.helpdesktsi.mapper.SupportTicketMapper;
import com.example.helpdesktsi.model.SupportTicket;
import com.example.helpdesktsi.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket-tracker")
public class TicketTrackerController {

    @Autowired
    private SupportTicketService supportTicketService;
    private SupportTicketMapper supportTicketMapper;

    public TicketTrackerController(SupportTicketService supportTicketService,
                                   SupportTicketMapper supportTicketMapper) {
        this.supportTicketService = supportTicketService;
        this.supportTicketMapper = supportTicketMapper;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<SupportTicketDTO>> getAllTickets() {

        List<SupportTicket> supportTickets = supportTicketService.getAllSupportTickets();

        List<SupportTicketDTO> supportTicketsDTOs = supportTickets.stream()
                .map(supportTicketMapper::toDto)
                .toList();

        return ResponseEntity.ok(supportTicketsDTOs);


    }

    @PostMapping("/resolve")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> createTicket(@RequestParam("id") Long id) {

        supportTicketService.resolveTicket(id);
        return ResponseEntity.ok("Ticket resolved");

    }


}
