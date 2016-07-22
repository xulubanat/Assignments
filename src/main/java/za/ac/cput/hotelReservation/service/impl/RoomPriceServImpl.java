package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.RoomPrice;
import za.ac.cput.hotelReservation.repository.RoomPriceRepo;
import za.ac.cput.hotelReservation.service.RoomPriceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
@Service
public class RoomPriceServImpl implements RoomPriceService
{
    @Autowired
    RoomPriceRepo repository;

    @Override
    public RoomPrice findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public RoomPrice update(RoomPrice entity) {
        return repository.save(entity);
    }

    @Override
    public RoomPrice save(RoomPrice entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(RoomPrice entity) {
        repository.delete(entity);
    }

    @Override
    public List<RoomPrice> findAll() {
        List<RoomPrice> allRoomPrice = new ArrayList<>();

        Iterable<RoomPrice> roomPrices = repository.findAll();
        for(RoomPrice roomPrice : roomPrices)
        {
            allRoomPrice.add(roomPrice);
        }
        return allRoomPrice;
    }
}
