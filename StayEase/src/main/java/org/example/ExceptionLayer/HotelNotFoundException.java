package org.example.ExceptionLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelNotFoundException extends RuntimeException {
    private String message;
}
