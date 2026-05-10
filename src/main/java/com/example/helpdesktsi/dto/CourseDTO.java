package com.example.helpdesktsi.dto;

import com.example.helpdesktsi.model.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {



    private String name;

    private String code;

    private String instructorName;

    private String instructorSurname;

}
