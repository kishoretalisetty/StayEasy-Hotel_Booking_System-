package org.example.ServiceLayer;

import org.example.DTOSLayer.UserDetailsDto;
import org.example.Entities.User;
import org.example.ExceptionLayer.UserNotFoundException;
import org.example.RepositoryLayer.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDetailsDto userDetailsDto){
      User user=new ModelMapper().map(userDetailsDto, User.class);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      if(user.getRole()==null){
          user.setRole("CUSTOMER");
      }
      userRepository.save(user);
      return user;
    }

    public User getUserById(Long userId){
        Optional<User> user= userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found by this Id :-"+userId);
        }
        return user.get();
    }


}
