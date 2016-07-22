package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.repository.HotelRepo;
import za.ac.cput.hotelReservation.service.HotelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    HotelRepo repository;

    @Override
    public Hotel findById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public Hotel save(Hotel entity)
    {
        return repository.save(entity);
    }

    @Override
    public Hotel update(Hotel entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Hotel entity)
    {
        repository.delete(entity);
    }

    @Override
    public List<Hotel> findAll()
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
