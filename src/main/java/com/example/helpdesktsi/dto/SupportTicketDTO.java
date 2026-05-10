package com.example.helpdesktsi.dto;

import com.example.helpdesktsi.enums.Category;
import com.example.helpdesktsi.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SupportTicketDTO {

    private Long id;

    private String userFirstName;

    private String userLastName;

    private String title;

    private String description;

    private String category;

    private String status;

    LocalDateTime createdAt;

    LocalDateTime resolvedAt;

}
