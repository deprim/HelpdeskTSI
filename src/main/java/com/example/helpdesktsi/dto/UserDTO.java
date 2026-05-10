package com.example.helpdesktsi.dto;

import com.example.helpdesktsi.model.Group;
import com.example.helpdesktsi.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private String group;




}
