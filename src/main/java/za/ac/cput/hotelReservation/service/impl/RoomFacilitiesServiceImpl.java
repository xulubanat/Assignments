package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.RoomFacilities;
import za.ac.cput.hotelReservation.repository.RoomFacilitiesRepo;
import za.ac.cput.hotelReservation.service.RoomFacilitiesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class RoomFacilitiesServiceImpl implements RoomFacilitiesService
{
    @Autowired
    RoomFacilitiesRepo repository;

    @Override
    public RoomFacilities findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public RoomFacilities save(RoomFacilities entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(RoomFacilities entity) {
        repository.delete(entity);
    }

    @Override
    public RoomFacilities update(RoomFacilities entity) {
        return repository.save(entity);
    }

    @Override
    public List<RoomFacilities> findAll() {

        List<RoomFacilities> allRoomFacilities = new ArrayList<>();

        Iterable<RoomFacilities> roomFacilitieses = repository.findAll();
        for(RoomFacilities roomFacility : roomFacilitieses)
        {
            allRoomFacilities.add(roomFacility);
        }
        return allRoomFacilities;
    }
}
