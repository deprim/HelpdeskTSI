package com.example.helpdesktsi.repository;

import com.example.helpdesktsi.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByGroupIdAndDateOrderByStartTimeAsc(
            Long groupId,
            LocalDate date
    );



}
