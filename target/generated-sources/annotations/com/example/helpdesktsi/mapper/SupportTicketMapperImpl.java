package com.example.helpdesktsi.mapper;

import com.example.helpdesktsi.dto.SupportTicketDTO;
import com.example.helpdesktsi.enums.Category;
import com.example.helpdesktsi.model.SupportTicket;
import com.example.helpdesktsi.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-11T01:53:48+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class SupportTicketMapperImpl implements SupportTicketMapper {

    @Override
    public SupportTicketDTO toDto(SupportTicket supportTicket) {
        if ( supportTicket == null ) {
            return null;
        }

        SupportTicketDTO supportTicketDTO = new SupportTicketDTO();

        supportTicketDTO.setUserFirstName( supportTicketUserFirstName( supportTicket ) );
        supportTicketDTO.setUserLastName( supportTicketUserLastName( supportTicket ) );
        if ( supportTicket.getCategory() != null ) {
            supportTicketDTO.setCategory( supportTicket.getCategory().name() );
        }
        supportTicketDTO.setId( supportTicket.getId() );
        supportTicketDTO.setTitle( supportTicket.getTitle() );
        supportTicketDTO.setDescription( supportTicket.getDescription() );
        supportTicketDTO.setStatus( supportTicket.getStatus() );
        supportTicketDTO.setCreatedAt( supportTicket.getCreatedAt() );
        supportTicketDTO.setResolvedAt( supportTicket.getResolvedAt() );

        return supportTicketDTO;
    }

    @Override
    public SupportTicket toEntity(SupportTicketDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SupportTicket supportTicket = new SupportTicket();

        supportTicket.setTitle( dto.getTitle() );
        supportTicket.setDescription( dto.getDescription() );
        if ( dto.getCategory() != null ) {
            supportTicket.setCategory( Enum.valueOf( Category.class, dto.getCategory() ) );
        }
        supportTicket.setResolvedAt( dto.getResolvedAt() );

        supportTicket.setStatus( "OPEN" );
        supportTicket.setCreatedAt( java.time.LocalDateTime.now() );

        return supportTicket;
    }

    private String supportTicketUserFirstName(SupportTicket supportTicket) {
        User user = supportTicket.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getFirstName();
    }

    private String supportTicketUserLastName(SupportTicket supportTicket) {
        User user = supportTicket.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getLastName();
    }
}
