package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.ReservationFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/12/25.
 */
public class ReservationTest
{
    private String arrivalDate;
    private String departDate;
    private boolean smookingRoom;
    private int numOfBed;
    private String highOrLowFloor;

    @Before

    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        Map<String, String> dates = new HashMap<>();
        List<Hotel> hotel = new ArrayList<>();
        List<Guest> guest = new ArrayList<>();

        dates.put("arrivalDate", "28-Dec-2015");
        dates.put("departDate", "29-Dec-2015");

        Reservation reservation = ReservationFactory.createReservation(dates, false, 2, "high", hotel, guest);

        Assert.assertEquals("28-Dec-2015", reservation.getArrivalDate());
        Assert.assertEquals(false, reservation.isSmookingRoom());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Map<String, String> dates = new HashMap<>();
        List<Hotel> hotel = new ArrayList<>();
        List<Guest> guest = new ArrayList<>();

        dates.put("arrivalDate", "28-Dec-2015");
        dates.put("departDate", "29-Dec-2015");

        Reservation reservation = ReservationFactory.createReservation(dates, false, 2, "high", hotel, guest);
        Reservation newReserv = new Reservation.Builder(reservation.getArrivalDate()).smookingRoom(true).build();

        Assert.assertEquals("28-Dec-2015", reservation.getArrivalDate());
        Assert.assertEquals(false, reservation.isSmookingRoom());
        Assert.assertEquals("28-Dec-2015", newReserv.getArrivalDate());
        Assert.assertEquals(true, newReserv.isSmookingRoom());
    }
}
