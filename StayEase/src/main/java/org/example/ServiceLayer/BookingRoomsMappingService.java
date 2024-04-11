package org.example.ServiceLayer;

import org.example.DTOSLayer.BookRoomDetailsDto;
import org.example.DTOSLayer.VaccateDto;
import org.example.Entities.BookingRoomsMapping;
import org.example.Entities.Hotel;
import org.example.Entities.User;
import org.example.ExceptionLayer.BookingRoomsMappingException;
import org.example.ExceptionLayer.UserNotFoundException;
import org.example.RepositoryLayer.BookingRoomsMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingRoomsMappingService {

    @Autowired
    private BookingRoomsMappingRepository bookingRoomsMappingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    public BookingRoomsMapping bookRoom(BookRoomDetailsDto bookRoomDetailsDto){
       User user= userService.getUserById(bookRoomDetailsDto.getUserId());
       Hotel hotel= hotelService.getHotelById(bookRoomDetailsDto.getHotelId());

       BookingRoomsMapping bookingRoomsMapping=new BookingRoomsMapping();
       bookingRoomsMapping.setUserId(user.getId());
       bookingRoomsMapping.setHotelId(hotel.getId());
       bookingRoomsMapping.setName(user.getName());
       bookingRoomsMapping.setCheckin(bookRoomDetailsDto.getCheckin());

       if(bookRoomDetailsDto.getCheckout()==null){
           bookingRoomsMapping.setCheckout(bookRoomDetailsDto.getCheckin().plusDays(1));
       }
       else{
           bookingRoomsMapping.setCheckout(bookRoomDetailsDto.getCheckout());
       }
//       bookingRoomsMapping.setUserVaccate(false);

       hotelService.updateRoom(hotel,-1);

       bookingRoomsMappingRepository.save(bookingRoomsMapping);
       return bookingRoomsMapping;
    }

    public VaccateDto vaccateRoom(Long  bookRoomMapId){
        Optional<BookingRoomsMapping> bookingRoomsMappingOpt
                =bookingRoomsMappingRepository.findById( bookRoomMapId);
        if(bookingRoomsMappingOpt.isEmpty()){
            throw new BookingRoomsMappingException("BookingRoomsMapping Is Not Found By this "+ bookRoomMapId+" id in this Hotel ");
        }
        BookingRoomsMapping mapping=bookingRoomsMappingOpt.get();
        Hotel hotel=hotelService.getHotelById(mapping.getHotelId());
        hotelService.updateRoom(hotel,1);
        mapping.setUserVaccate(true);
        mapping.setCheckout(LocalDateTime.now());
        bookingRoomsMappingRepository.save(mapping);
        return new VaccateDto(hotel, mapping);
    }

    public List<BookingRoomsMapping> findAll(){
       List<BookingRoomsMapping> list= bookingRoomsMappingRepository.findAll();
       List<BookingRoomsMapping> ans=list.stream().filter(b->!b.isUserVaccate()).collect(Collectors.toList());
       return ans;
    }
}
