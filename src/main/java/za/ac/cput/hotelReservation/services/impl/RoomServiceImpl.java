package za.ac.cput.hotelReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hotelReservation.domain.Room;
import za.ac.cput.hotelReservation.repository.RoomRepo;
import za.ac.cput.hotelReservation.services.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
public class RoomServiceImpl implements RoomService
{
    @Autowired
    RoomRepo repository;

    @Override
    public List<Room> getRoom()
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
