package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.repository.ReservationRepo;
import za.ac.cput.hotelReservation.service.ReservationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class ReservationServiceImpl implements ReservationService
{
    @Autowired
    ReservationRepo repository;

    @Override
    public Reservation findById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public Reservation save(Reservation entity)
    {
        return repository.save(entity);
    }

    @Override
    public Reservation update(Reservation entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Reservation entity)
    {
        repository.delete(entity);
    }

    @Override
    public List<Reservation> findAll()
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
