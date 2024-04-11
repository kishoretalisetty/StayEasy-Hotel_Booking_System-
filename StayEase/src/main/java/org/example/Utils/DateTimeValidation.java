package org.example.Utils;

import lombok.extern.slf4j.Slf4j;
import org.example.ExceptionLayer.InvalidDateAndTimeException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Slf4j
public class DateTimeValidation {
    public boolean dateAndTimeValidation(LocalDateTime checkin, LocalDateTime checkout){
        log.info(" LocalDateTime= {}, CheckIn Time= {}, checkout time= {} ",LocalDateTime.now(),checkin,checkout );


        if(checkout!=null && checkout.isBefore(checkin)){
            throw new InvalidDateAndTimeException("Invalid CheckOut Time checkin = "+checkin+" checkout = "+checkout);
        }
        return true;
    }
}
