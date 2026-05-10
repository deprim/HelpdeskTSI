package com.example.helpdesktsi.model;

import com.example.helpdesktsi.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "roles")
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserRole roleName;

}
