package org.example.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BookingRooms")
public class BookingRoomsMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "name")
    @NonNull
    private String name;
    @NonNull
    private Long userId;
    @NonNull
    private Long hotelId;
    @NonNull
    @Column(name = "checkIn_Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkin;
    @NonNull
    @Column(name = "checkout_Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkout;
    @Column(name = "userVaccate")
    private boolean userVaccate;

}
