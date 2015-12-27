package za.ac.cput.hotelReservation.services;

import za.ac.cput.hotelReservation.domain.Reservation;

import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
public interface ReservationService
{
    List<Reservation> getReservation();
}
