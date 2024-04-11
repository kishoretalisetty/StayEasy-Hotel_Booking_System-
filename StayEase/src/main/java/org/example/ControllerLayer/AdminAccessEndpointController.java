package org.example.ControllerLayer;

import org.example.DTOSLayer.HotelDetailsDto;
import org.example.Entities.Hotel;
import org.example.ServiceLayer.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminAccessEndpointController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("create/hotel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Hotel> addHotel(@RequestBody HotelDetailsDto hotelDetailsDto){

        return ResponseEntity.ok(hotelService.addHotel(hotelDetailsDto));
    }

    @DeleteMapping("delete/hotel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteHotel(@RequestAttribute(name = "hotelId") Long hotelId){

      hotelService.deleteHotel(hotelId);

        return "Deleted Successfully";
    }
}
