package org.example.ControllerLayer;

import org.example.DTOSLayer.HotelUpdateDetailsDto;
import org.example.Entities.BookingRoomsMapping;
import org.example.Entities.Hotel;
import org.example.ServiceLayer.BookingRoomsMappingService;
import org.example.ServiceLayer.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerAccessEndpointController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private BookingRoomsMappingService bookingRoomsMappingService;

    @PutMapping("/update/hotel")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<Hotel> updateHotelDetails(@RequestBody HotelUpdateDetailsDto
                                                                hotelUpdateDetailsDto){
       Hotel hotel= hotelService.updateDetails(hotelUpdateDetailsDto);
       return ResponseEntity.ok(hotel);
    }

    @GetMapping("/getAllBookedRooms")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<List<BookingRoomsMapping>> getAllBookedRooms(){
        return ResponseEntity.ok(bookingRoomsMappingService.findAll());
    }
}
