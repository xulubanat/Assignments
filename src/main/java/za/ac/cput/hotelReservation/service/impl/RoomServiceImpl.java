package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.Room;
import za.ac.cput.hotelReservation.repository.RoomRepo;
import za.ac.cput.hotelReservation.service.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class RoomServiceImpl implements RoomService
{
    @Autowired
    RoomRepo repository;

    @Override
    public Room findById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public Room save(Room entity)
    {
        return repository.save(entity);
    }

    @Override
    public Room update(Room entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Room entity)
    {
        repository.delete(entity);
    }

    @Override
    public List<Room> findAll()
    {
        List<Room> allRooms = new ArrayList<>();

        Iterable<Room> rooms = repository.findAll();
        for(Room room : rooms)
        {
            allRooms.add(room);
        }
        return allRooms;
    }
}
