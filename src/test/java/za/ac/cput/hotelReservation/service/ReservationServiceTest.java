package za.ac.cput.hotelReservation.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
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
 * Created by student on 2016/01/03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ReservationServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private ReservationService service;

    @Test
    public void create() throws Exception
    {
        Map<String, String> dates = new HashMap<>();
        List<Hotel> hotel = new ArrayList<>();
        List<Guest> guest = new ArrayList<>();

        dates.put("arrivalDate", "28-Dec-2015");
        dates.put("departDate", "29-Dec-2015");

        Reservation reservation = ReservationFactory.createReservation(dates, false, 2, "high", null, null);
        service.save(reservation);
        id = reservation.getReservationId();

        Assert.assertNotNull(reservation);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Reservation reservation = service.findById(id);
        Assert.assertEquals("28-Dec-2015", reservation.getArrivalDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Reservation reservation = service.findById(id);
        Reservation newReserv = new Reservation.Builder(reservation.getArrivalDate()).copy(reservation).smookingRoom(true).build();
        service.update(newReserv);

        Reservation updatedReservation = service.findById(id);
        Assert.assertEquals(true, updatedReservation.isSmookingRoom());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Reservation reservation = service.findById(id);
        service.delete(reservation);
        Reservation deleteReserv = service.findById(id);
        Assert.assertNull(deleteReserv);
    }
}
