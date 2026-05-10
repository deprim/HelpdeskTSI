package com.example.helpdesktsi.intenthandlers;

import com.example.helpdesktsi.mapper.CourseMapper;
import com.example.helpdesktsi.model.User;
import com.example.helpdesktsi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseHandler implements IntentHandler {



    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseHandler(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @Override
    public String getIntentName() {
        return "GET_COURSE";
    }

    @Override
    public String handle(User user) {
        return "";
    }
}
