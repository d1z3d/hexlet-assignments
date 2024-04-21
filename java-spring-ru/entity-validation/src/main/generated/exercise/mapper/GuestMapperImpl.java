package exercise.mapper;

import exercise.dto.GuestCreateDTO;
import exercise.dto.GuestDTO;
import exercise.model.Guest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-21T22:08:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class GuestMapperImpl extends GuestMapper {

    @Override
    public Guest map(GuestCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setName( dto.getName() );
        guest.setEmail( dto.getEmail() );
        guest.setPhoneNumber( dto.getPhoneNumber() );
        guest.setClubCard( dto.getClubCard() );
        guest.setCardValidUntil( dto.getCardValidUntil() );

        return guest;
    }

    @Override
    public GuestDTO map(Guest model) {
        if ( model == null ) {
            return null;
        }

        GuestDTO guestDTO = new GuestDTO();

        guestDTO.setId( model.getId() );
        guestDTO.setName( model.getName() );
        guestDTO.setEmail( model.getEmail() );
        guestDTO.setPhoneNumber( model.getPhoneNumber() );
        guestDTO.setClubCard( model.getClubCard() );
        guestDTO.setCardValidUntil( model.getCardValidUntil() );
        guestDTO.setCreatedAt( model.getCreatedAt() );

        return guestDTO;
    }
}
