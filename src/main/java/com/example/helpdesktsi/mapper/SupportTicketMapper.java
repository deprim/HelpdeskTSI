package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.SupportTicketDTO;
import com.example.helpdesktsi.model.SupportTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupportTicketMapper {

    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "category", target = "category")
    SupportTicketDTO toDto(SupportTicket supportTicket);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "OPEN")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    SupportTicket toEntity(SupportTicketDTO dto);

}
