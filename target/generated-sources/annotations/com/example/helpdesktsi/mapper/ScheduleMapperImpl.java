package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.ScheduleDTO;
import com.example.helpdesktsi.model.Course;
import com.example.helpdesktsi.model.Group;
import com.example.helpdesktsi.model.Room;
import com.example.helpdesktsi.model.Schedule;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-12T22:14:50+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    @Override
    public ScheduleDTO toDto(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        ScheduleDTO.ScheduleDTOBuilder scheduleDTO = ScheduleDTO.builder();

        scheduleDTO.courseName( scheduleCourseName( schedule ) );
        scheduleDTO.roomNumber( scheduleRoomRoomNumber( schedule ) );
        scheduleDTO.groupName( scheduleGroupName( schedule ) );
        scheduleDTO.dayOfWeek( schedule.getDayOfWeek() );
        scheduleDTO.startTime( schedule.getStartTime() );
        scheduleDTO.endTime( schedule.getEndTime() );
        scheduleDTO.date( schedule.getDate() );

        return scheduleDTO.build();
    }

    private String scheduleCourseName(Schedule schedule) {
        Course course = schedule.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getName();
    }

    private Integer scheduleRoomRoomNumber(Schedule schedule) {
        Room room = schedule.getRoom();
        if ( room == null ) {
            return null;
        }
        return room.getRoomNumber();
    }

    private String scheduleGroupName(Schedule schedule) {
        Group group = schedule.getGroup();
        if ( group == null ) {
            return null;
        }
        return group.getName();
    }
}
