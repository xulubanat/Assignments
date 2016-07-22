package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.RoomType;
import za.ac.cput.hotelReservation.repository.RoomTypeRepo;
import za.ac.cput.hotelReservation.service.RoomTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
@Service
public class RoomTypeServImpl implements RoomTypeService
{
    @Autowired
    RoomTypeRepo repository;

    @Override
    public RoomType findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public RoomType save(RoomType entity) {
        return repository.save(entity);
    }

    @Override
    public RoomType update(RoomType entity) {
        return repository.save(entity);
    }

    @Override
    public List<RoomType> findAll() {
        List<RoomType> allRoomType = new ArrayList<>();

        Iterable<RoomType> roomTypes = repository.findAll();
        for(RoomType roomType : roomTypes)
        {
            allRoomType.add(roomType);
        }
        return allRoomType;
    }

    @Override
    public void delete(RoomType entity) {
        repository.delete(entity);
    }
}
