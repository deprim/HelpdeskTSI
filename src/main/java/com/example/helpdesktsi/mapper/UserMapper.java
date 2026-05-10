package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.ScheduleDTO;
import com.example.helpdesktsi.dto.UserDTO;
import com.example.helpdesktsi.model.Schedule;
import com.example.helpdesktsi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper{

    @Mapping(source = "role.roleName", target = "role")
    @Mapping(source = "group.name", target = "group")
    UserDTO toDto(User user);


}
