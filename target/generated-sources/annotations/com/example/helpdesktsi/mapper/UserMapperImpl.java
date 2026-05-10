package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.UserDTO;
import com.example.helpdesktsi.enums.UserRole;
import com.example.helpdesktsi.model.Group;
import com.example.helpdesktsi.model.Role;
import com.example.helpdesktsi.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T01:53:48+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        UserRole roleName = userRoleRoleName( user );
        if ( roleName != null ) {
            userDTO.role( roleName.name() );
        }
        userDTO.group( userGroupName( user ) );
        userDTO.username( user.getUsername() );
        userDTO.firstName( user.getFirstName() );
        userDTO.lastName( user.getLastName() );
        userDTO.email( user.getEmail() );

        return userDTO.build();
    }

    private UserRole userRoleRoleName(User user) {
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getRoleName();
    }

    private String userGroupName(User user) {
        Group group = user.getGroup();
        if ( group == null ) {
            return null;
        }
        return group.getName();
    }
}
