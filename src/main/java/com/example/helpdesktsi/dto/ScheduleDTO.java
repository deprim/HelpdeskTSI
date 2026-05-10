package com.example.helpdesktsi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    private String courseName;
    private Integer roomNumber;
    private String groupName;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "courseName='" + courseName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", groupName='" + groupName + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", date=" + date +
                '}';
    }
}