package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.CourseDTO;
import com.example.helpdesktsi.model.Course;
import com.example.helpdesktsi.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-12T22:14:50+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO.CourseDTOBuilder courseDTO = CourseDTO.builder();

        courseDTO.instructorName( courseInstructorFirstName( course ) );
        courseDTO.instructorSurname( courseInstructorLastName( course ) );
        courseDTO.name( course.getName() );
        courseDTO.code( course.getCode() );

        return courseDTO.build();
    }

    private String courseInstructorFirstName(Course course) {
        User instructor = course.getInstructor();
        if ( instructor == null ) {
            return null;
        }
        return instructor.getFirstName();
    }

    private String courseInstructorLastName(Course course) {
        User instructor = course.getInstructor();
        if ( instructor == null ) {
            return null;
        }
        return instructor.getLastName();
    }
}
