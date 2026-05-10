package com.example.helpdesktsi.model;

import com.example.helpdesktsi.enums.RoomType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_number")
    @NonNull
    private Integer roomNumber;

    @Column(name = "capacity")
    @NonNull
    private Integer capacity;

    @Column(name = "type")
    @NonNull
    @Enumerated(EnumType.STRING)
    private RoomType type;




}
