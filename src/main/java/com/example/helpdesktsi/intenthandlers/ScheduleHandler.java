package com.example.helpdesktsi.intenthandlers;

import com.example.helpdesktsi.dto.ScheduleDTO;
import com.example.helpdesktsi.mapper.ScheduleMapper;
import com.example.helpdesktsi.model.Schedule;
import com.example.helpdesktsi.model.User;
import com.example.helpdesktsi.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleHandler implements IntentHandler {


    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleHandler(ScheduleService scheduleService,
                                ScheduleMapper scheduleMapper) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public String getIntentName() {
        return "GET_SCHEDULE";
    }

    @Override
    public String handle(User user) {

        List<Schedule> todayScheduleList = scheduleService.findAllSchedulesToday(user.getGroup().getId());

        String result = todayScheduleList.stream()
                .map(scheduleMapper::toDto)
                .map(ScheduleDTO::toString)
                .collect(Collectors.joining("\n"));

        return result.isBlank() ? "NO_DATA_FOUND" : result;

    }
}
