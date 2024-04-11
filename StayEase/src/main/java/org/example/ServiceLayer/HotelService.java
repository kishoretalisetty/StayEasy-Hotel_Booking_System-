package org.example.ServiceLayer;


import org.example.DTOSLayer.HotelDetailsDto;
import org.example.DTOSLayer.HotelUpdateDetailsDto;
import org.example.Entities.Hotel;
import org.example.ExceptionLayer.HotelNotFoundException;
import org.example.RepositoryLayer.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(HotelDetailsDto hotelDetailsDto){
        Hotel hotel=new ModelMapper().map(hotelDetailsDto,Hotel.class);
        if(hotel.getNumberOfAvailableRooms()==null){
            hotel.setNumberOfAvailableRooms(hotel.getNumberOfRooms());
        }

        if(hotel.getDescription()==null){
            hotel.setDescription("Good hotel with clean rooms");
        }
        hotelRepository.save(hotel);
        return hotel;
    }

    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public  Hotel getHotelById(Long hotelId){
       Optional<Hotel> hotel =hotelRepository.findById(hotelId);
       if(hotel.isEmpty()){
           throw new HotelNotFoundException("Hotel is Not Found By this Id :- "+hotelId);
       }
       return hotel.get();
    }

    public  Hotel getHotelByName(String hotelName){
        Optional<Hotel> hotel =hotelRepository.findByName(hotelName);
        return hotel.get();
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public List<Hotel> getAllAvailableHotels(){
       List<Hotel> hotelList=getAllHotels();
       List<Hotel> hotels=hotelList.stream()
               .filter(h->h.getNumberOfAvailableRooms()>0)
               .collect(Collectors.toList());

       return hotels;
    }

    public Hotel updateDetails(HotelUpdateDetailsDto hotelUpdateDetailsDto) {
        Hotel hotel=getHotelById(hotelUpdateDetailsDto.getHotelId());
        if (hotelUpdateDetailsDto.getDescription()!=null){
            hotel.setDescription(
                    hotelUpdateDetailsDto.getDescription()
            );
        }

        if(hotelUpdateDetailsDto.getNumberOfAvailableRooms()!=null){
            hotel.setNumberOfAvailableRooms(
                    hotelUpdateDetailsDto.getNumberOfAvailableRooms()
            );
        }
        hotelRepository.save(hotel);
        return hotel;
    }
    public void updateRoom(Hotel hotel, int num){
        hotel.setNumberOfAvailableRooms(hotel.getNumberOfAvailableRooms()+num);
        hotelRepository.save(hotel);
    }
}
