package org.example.ExceptionLayer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String> handleHotelNotFoundException(HotelNotFoundException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidEmailAddressException.class)
    public ResponseEntity<String> handleInvalidEmailAddressException(InvalidEmailAddressException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingRoomsMappingException.class)
    public ResponseEntity<String> handleBookingRoomsMappingException(BookingRoomsMappingException e) {
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDateAndTimeException.class)
    public ResponseEntity<String> handleInvalidDateAndTimeException(InvalidDateAndTimeException e){
        return new ResponseEntity<>(" Exception : - " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
