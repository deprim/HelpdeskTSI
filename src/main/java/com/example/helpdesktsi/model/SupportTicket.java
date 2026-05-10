package com.example.helpdesktsi.model;

import com.example.helpdesktsi.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "support_tickets")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "description")
    @NonNull
    private String description;

    @Column(name = "category")
    @NonNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "status")
    @NonNull
    private String status;

    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "resolved_at")
    LocalDateTime resolvedAt = null;


}
