package org.example.ControllerLayer;

import org.example.DTOSLayer.BookRoomDetailsDto;
import org.example.DTOSLayer.VaccateDto;
import org.example.DTOSLayer.VaccateRoomIdDto;
import org.example.Entities.BookingRoomsMapping;
import org.example.ServiceLayer.BookingRoomsMappingService;
import org.example.Utils.DateTimeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerAccessEndpointController {

    @Autowired
    private BookingRoomsMappingService bookingRoomsMappingService;

    @Autowired
    private DateTimeValidation dateTimeValidation;

    @PostMapping("/book/room")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<BookingRoomsMapping> bookRoom(@RequestBody BookRoomDetailsDto bookRoomDetailsDto){
        dateTimeValidation.dateAndTimeValidation(bookRoomDetailsDto.getCheckin(),
                bookRoomDetailsDto.getCheckout());
        return ResponseEntity.ok(bookingRoomsMappingService.bookRoom(bookRoomDetailsDto));
    }

    @PutMapping("/vaccate/room")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<VaccateDto> vaccateRoom(@RequestBody VaccateRoomIdDto vaccateRoomIdDto){
        return ResponseEntity.ok(bookingRoomsMappingService.vaccateRoom( vaccateRoomIdDto.getBookRoomMapId()));
    }
}
