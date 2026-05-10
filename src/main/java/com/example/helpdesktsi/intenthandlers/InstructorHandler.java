package com.example.helpdesktsi.intenthandlers;

import com.example.helpdesktsi.dto.CourseDTO;
import com.example.helpdesktsi.dto.ScheduleDTO;
import com.example.helpdesktsi.mapper.CourseMapper;
import com.example.helpdesktsi.model.Course;
import com.example.helpdesktsi.model.User;
import com.example.helpdesktsi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstructorHandler implements IntentHandler{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Autowired
    public InstructorHandler(CourseRepository courseRepository,
                             CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public String getIntentName() {
        return "GET_INSTRUCTOR";
    }

    @Override
    public String handle(User user) {

        List<Course> courses = courseRepository.findAll();


        String result = courses.stream()
                .map(courseMapper::toDto)
                .map(CourseDTO::toString)
                .collect(Collectors.joining("\n"));

        return result.isBlank() ? "NO_DATA_FOUND" : result;

    }
}
