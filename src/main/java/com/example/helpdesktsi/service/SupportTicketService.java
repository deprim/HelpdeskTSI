package com.example.helpdesktsi.service;

import com.example.helpdesktsi.dto.SupportTicketDTO;
import com.example.helpdesktsi.mapper.SupportTicketMapper;
import com.example.helpdesktsi.model.SupportTicket;
import com.example.helpdesktsi.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SupportTicketService {

   private final SupportTicketRepository supportTicketRepository;
   private final SupportTicketMapper supportTicketMapper;

    @Autowired
    public SupportTicketService(SupportTicketRepository supportTicketRepository,
                                SupportTicketMapper supportTicketMapper) {
        this.supportTicketRepository = supportTicketRepository;
        this.supportTicketMapper = supportTicketMapper;
    }


    @Transactional
    public void createSupportTicket(SupportTicket ticket) {
           supportTicketRepository.save(ticket);
    }

    public List<SupportTicketDTO> getSupportTicket(Long id) {
        List<SupportTicket> supportTicket = supportTicketRepository.findByUserId(id);
        return supportTicket.stream()
                .map(supportTicketMapper::toDto)
                .toList();


    }

    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    @Transactional
    public void resolveTicket(Long id) {
        SupportTicket ticket = supportTicketRepository.findById(id).orElseThrow();
        ticket.setStatus("RESOLVED");
        supportTicketRepository.save(ticket);
    }



}
