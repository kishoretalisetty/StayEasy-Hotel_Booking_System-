package org.example.DTOSLayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelUpdateDetailsDto {
    @NonNull
    private Long hotelId;
    private String description;
    private Long numberOfAvailableRooms;

    public HotelUpdateDetailsDto(Long hotelId,String description){
        this.hotelId=hotelId;
        this.description=description;
    }

    public HotelUpdateDetailsDto(Long hotelId, Long numberOfAvailableRooms){
        this.hotelId=hotelId;
        this.numberOfAvailableRooms=numberOfAvailableRooms;
    }


}
