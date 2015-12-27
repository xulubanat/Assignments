package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Reservation;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/12/25.
 */
public class ReservationFactory
{
    public static Reservation createReservation(Map<String, String> dates, boolean smookingRoom, int numOfBed, String highOrLowFloor, List<Hotel> hotel, List<Guest> guest)
    {
        Reservation reservation = new Reservation.Builder(dates.get("arrivalDate")).departDate(dates.get("departDate")).smookingRoom(smookingRoom).numOfBed(numOfBed).highOrLowFloor(highOrLowFloor).hotel(hotel).guest(guest).build();
        return reservation;
    }
}
