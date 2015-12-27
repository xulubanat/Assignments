package za.ac.cput.hotelReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.repository.ReservationRepo;
import za.ac.cput.hotelReservation.services.ReservationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
public class ReservationServiceImpl implements ReservationService
{
    @Autowired
    ReservationRepo repository;

    @Override
    public List<Reservation> getReservation()
    {
        List<Reservation> allReservations = new ArrayList<>();

        Iterable<Reservation> reservations = repository.findAll();
        for(Reservation reservation : reservations)
        {
            allReservations.add(reservation);
        }
        return allReservations;
    }
}
