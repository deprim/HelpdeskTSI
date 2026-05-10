package com.example.helpdesktsi.service;

import com.example.helpdesktsi.model.Schedule;
import com.example.helpdesktsi.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAllSchedulesToday(Long groupId) {
        return scheduleRepository.findByGroupIdAndDateOrderByStartTimeAsc(groupId, LocalDate.now());
    }


}
