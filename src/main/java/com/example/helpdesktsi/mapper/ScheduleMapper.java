package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.ScheduleDTO;
import com.example.helpdesktsi.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    @Mapping(source = "course.name", target = "courseName")
    @Mapping(source = "room.roomNumber", target = "roomNumber")
    @Mapping(source = "group.name", target = "groupName")
    ScheduleDTO toDto(Schedule schedule);

}
