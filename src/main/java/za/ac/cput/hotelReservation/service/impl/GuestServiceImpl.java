package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.repository.GuestRepo;
import za.ac.cput.hotelReservation.service.GuestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class GuestServiceImpl implements GuestService
{
    @Autowired
    GuestRepo repository;

    @Override
    public Guest findById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public Guest save(Guest entity)
    {
        return repository.save(entity);
    }

    @Override
    public Guest update(Guest entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Guest entity)
    {
        repository.delete(entity);
    }

    @Override
    public List<Guest> findAll()
    {
        List<Guest> allGuests = new ArrayList<>();

        Iterable<Guest> guests = repository.findAll();
        for(Guest guest : guests)
        {
            allGuests.add(guest);
        }
        return allGuests;
    }

}
