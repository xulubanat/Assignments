package za.ac.cput.hotelReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.repository.GuestRepo;
import za.ac.cput.hotelReservation.services.GuestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
public class GuestServiceImpl implements GuestService
{
    @Autowired
    GuestRepo repository;

    @Override
    public List<Guest> getGuest()
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
