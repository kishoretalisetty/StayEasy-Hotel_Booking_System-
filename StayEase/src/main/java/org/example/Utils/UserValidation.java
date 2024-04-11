package org.example.Utils;
import org.example.Entities.User;
import org.example.ExceptionLayer.InvalidDateAndTimeException;
import org.example.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserValidation {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUserValidation(String userName){
        Optional<User> optionalUser=userRepository.findByName(userName);

        return optionalUser.isEmpty();
    }

    public boolean emailValidation(String email){
        //user "@gmail.com" = 10 length

        int length=email.length();
        String st=email.substring(length-10);
        return st.equals("@gmail.com");
    }




}
