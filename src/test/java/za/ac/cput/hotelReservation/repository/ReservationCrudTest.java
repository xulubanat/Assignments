package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.factory.ReservationFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/12/27.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ReservationCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private ReservationRepo repository;

    @Test
    public void create() throws Exception
    {
        Map<String, String> dates = new HashMap<>();
        List<Hotel> hotel = new ArrayList<>();
        List<Guest> guest = new ArrayList<>();

        dates.put("arrivalDate", "28-Dec-2015");
        dates.put("departDate", "29-Dec-2015");

        Reservation reservation = ReservationFactory.createReservation(dates, false, 2, "high", null, null);
        repository.save(reservation);
        id = reservation.getReservationId();

        Assert.assertNotNull(reservation.getReservationId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Reservation reservation = repository.findOne(id);
        Assert.assertNotNull(reservation.getReservationId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Reservation reservation = repository.findOne(id);
        repository.delete(reservation);
        Reservation deleteReserv = repository.findOne(id);
        Assert.assertNull(deleteReserv);
    }
}
