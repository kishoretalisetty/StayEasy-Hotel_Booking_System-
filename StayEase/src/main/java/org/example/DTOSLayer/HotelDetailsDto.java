package org.example.DTOSLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDetailsDto {
    @NonNull
    private String name;
    @NonNull
    private String location;
    private String description;
    @NonNull
    private Long numberOfRooms;
    private Long numberOfAvailableRooms;

    public HotelDetailsDto(@NonNull String name, @NonNull String location, @NonNull Long numberOfRooms) {
        this.name = name;
        this.location = location;
        this.numberOfRooms = numberOfRooms;
    }
}
