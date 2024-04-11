package org.example.ControllerLayer;

import lombok.extern.slf4j.Slf4j;
import org.example.DTOSLayer.UserDetailsDto;
import org.example.Entities.Hotel;
import org.example.Entities.User;
import org.example.ExceptionLayer.EmailAlreadyExistsException;
import org.example.ExceptionLayer.InvalidEmailAddressException;
import org.example.Filter.JwtServiceImp.JwtService;
import org.example.Pojos.AuthRequest;
import org.example.ServiceLayer.HotelService;
import org.example.ServiceLayer.UserService;
import org.example.Utils.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class PublicAccessEndpointController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private UserValidation userValidation;

    @PostMapping("/register/user")
    public ResponseEntity<User> addUser(@RequestBody UserDetailsDto userDetailsDto){

        // Email Structure Checking
        log.info("UserDetailsDto = {} ",userDetailsDto);

        if( userDetailsDto.getName()==null ||userDetailsDto.getName().length()==0
                || !userValidation.emailValidation(userDetailsDto.getName())){
            throw new InvalidEmailAddressException("Email Address Format is Wrong");
        }

        // check for is email is already Exists
        if(!userValidation.registerUserValidation(userDetailsDto.getName())){
            throw new EmailAlreadyExistsException(" Email is Already Exists");
        }

        return ResponseEntity.ok(userService.addUser(userDetailsDto));
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        log.info("userName = {} , password = {}",authRequest.getUsername(),authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword())
        );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid User");
        }
    }

   @GetMapping("/getAllAvailableHotels")
   public List<Hotel>  getAllAvailableHotels(){
        return hotelService.getAllAvailableHotels();
   }
}
