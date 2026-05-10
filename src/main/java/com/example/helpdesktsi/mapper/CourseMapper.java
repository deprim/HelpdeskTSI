package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.CourseDTO;
import com.example.helpdesktsi.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "instructor.firstName", target = "instructorName")
    @Mapping(source = "instructor.lastName", target = "instructorSurname")
    CourseDTO toDto(Course course);

}
