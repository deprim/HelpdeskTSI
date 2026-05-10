package com.example.helpdesktsi.model;

import com.example.helpdesktsi.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "lab_reservations")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class LabReservation {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @Column(name = "reservation_date")
    @NonNull
    private LocalDate reservationDate;

    @Column(name = "start_time")
    @NonNull
    private LocalTime reservationTime;

    @Column(name = "end_time")
    @NonNull
    private LocalTime endTime;

    @Column(name = "status")
    @NonNull
    private ReservationStatus status;

}
