package za.ac.cput.hotelReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.repository.HotelRepo;
import za.ac.cput.hotelReservation.services.HotelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
public class HotelServiceImpl implements HotelService
{
    @Autowired
    HotelRepo repository;

    @Override
    public List<Hotel> getHotel()
    {
        List<Hotel> allHotels = new ArrayList<>();

        Iterable<Hotel> hotels = repository.findAll();
        for(Hotel hotel : hotels)
        {
            allHotels.add(hotel);
        }
        return allHotels;
    }
}
