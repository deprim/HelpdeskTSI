package com.example.helpdesktsi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "code")
    @NonNull
    private String code;

    @JoinColumn(name = "instructor_id")
    @ManyToOne
    @NonNull
    private User instructor;


}
