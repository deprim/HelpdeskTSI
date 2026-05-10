package com.example.helpdesktsi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NonNull
    private Course course;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

    @Column(name = "day_of_week")
    @NonNull
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "start_time")
    @NonNull
    LocalTime startTime;

    @Column(name = "end_time")
    @NonNull
    LocalTime endTime;

    @Column(name = "date")
    @NonNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
