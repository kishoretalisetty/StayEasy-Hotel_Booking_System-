package org.example.DTOSLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Entities.BookingRoomsMapping;
import org.example.Entities.Hotel;

@Data
@AllArgsConstructor
public class VaccateDto {
   private Hotel hotel;
   private BookingRoomsMapping bookingRoomsMapping;
}
