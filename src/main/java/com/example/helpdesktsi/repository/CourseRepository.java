package com.example.helpdesktsi.repository;

import com.example.helpdesktsi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAll();

}
