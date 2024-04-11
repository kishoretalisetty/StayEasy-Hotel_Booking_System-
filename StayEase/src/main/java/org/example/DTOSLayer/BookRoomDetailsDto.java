package org.example.DTOSLayer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRoomDetailsDto {
    @NonNull
    private Long userId;
    @NonNull
    private Long hotelId;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkin;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkout;
}
